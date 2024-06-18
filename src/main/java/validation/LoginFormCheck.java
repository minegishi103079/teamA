package validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.EmailValidator;

import lombok.Getter;
import model.beans.AccountsBean;
import util.DbUtil;
@Getter
public class LoginFormCheck {
	
	
	private ArrayList<String> errors = new ArrayList<>();
	private AccountsBean account;

	public boolean validate(HttpServletRequest req) {


		boolean c = mailEmpty(req.getParameter("mail"));
		boolean d = mailLength(req.getParameter("mail"));
		boolean e = mailFormat(req.getParameter("mail"));
		boolean f = passEmpty(req.getParameter("password"));
		boolean g = passLength(req.getParameter("password"));
		boolean h = accountExist(req.getParameter("mail"));
		boolean i = passSame(req.getParameter("password"));

		boolean result =  c && d && e && f && g && h && i ;

		return result;
	}
	
	//メールアドレス必須入力チェック
		private boolean mailEmpty(String str) {
			if (str.isEmpty()) {
				errors.add("メールアドレスを入力して下さい。");
				return false;
			}
			return true;
		}
	
	//メールアドレス長さチェック
	private boolean mailLength(String str) {
		if (str.length() > 30) {
			errors.add("メールアドレスの指定が長すぎます。");
			return false;
		}
		return true;
	}
	
	//メールアドレス形式チェック
	private boolean mailFormat(String str) {
		
	    if (str != null) {
	        if(EmailValidator.getInstance().isValid(str)) {
	            return true;
	        }else {
	        	errors.add("メールアドレスの形式が誤っています。");
	        	return false;
	        }
	        
	    }
		return false;
		
	}
	
	//パスワード必須入力チェック
	private boolean passEmpty(String str) {
		if (str.isEmpty()) {
			errors.add("パスワードを入力して下さい。");
			return false;
		}
		return true;
	}
	
	//パスワード長さチェック
	private boolean passLength(String str) {
		if (str.length() > 100) {
			errors.add("パスワードが長すぎます。");
			return false;
		}
		return true;
	}
	
	//アカウントテーブル存在チェック
	private boolean accountExist(String str) {
		String sql = "select count(*), * from accounts where mail = ?";
		
		try( 
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs.getInt("count(*)") > 0) {
				account = new AccountsBean(
						rs.getInt("account_id"), 
						rs.getString("name"), 
						rs.getString("mail"),
						rs.getString("password"),
						rs.getString("authority")
						);
				return true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
		
	}
		
	//パスワードチェック
	private boolean passSame(String str1) {
		if (account == null) {
			return false;
		}
		if (!( str1.equals( account.getPassword() ) )) {
			errors.add("パスワードとパスワード（確認）の入力内容が異なっています。");
			return false;
		}
		return true;
	}
		
}
	
	

