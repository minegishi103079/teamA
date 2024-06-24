package validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.EmailValidator;

import lombok.Getter;
import util.DbUtil;

@Getter

public class AccountsFormCheck {
	private ArrayList<String> errors = new ArrayList<>();

	public boolean validate(HttpServletRequest req) {
//登録
		boolean a = nameCheck(req.getParameter("name"));
		boolean b = mailCheck(req.getParameter("mail"));
		boolean c = password1Check(req.getParameter("password1"));
		boolean d = password2Check(req.getParameter("password2"));
		boolean e = passSame1(req.getParameter("password1"),req.getParameter("password2"));

		boolean result = a && b && c && d && e;
		return result;
	}
//検索	
	public boolean validate2(HttpServletRequest req) {
		
		boolean k = nameLength(req.getParameter("name"));
		boolean l  = mailLength(req.getParameter("mail"));
		
		boolean result = k && l;
		
		return result;
		
	}
//編集
	public boolean validate3(HttpServletRequest req) {

		boolean a = nameCheck(req.getParameter("name"));
		boolean b = mailCheck(req.getParameter("mail"));
		boolean c = password1Check(req.getParameter("password1"));
		boolean d = password2Check(req.getParameter("password2"));
		boolean f = passSame2(req.getParameter("password1"),req.getParameter("password2"));

		boolean result = a && b && c && d && f;

		return result;
	}
	
	private boolean nameCheck(String name) {
		if(nameEmpty(name)) {
			return nameLength(name);
		}
		return false;
	}
	
	private boolean mailCheck(String mail) {
		if(mailEmpty(mail)) {
				return mailLength(mail)&mailFormat(mail);
		}
		return false;
	}
	
	private boolean password1Check(String password1) {
		if(passEmpty(password1)) {
			return passLength(password1);
		}
		return false;
	}
	
	private boolean password2Check(String password2) {
		if(passCheckEmpty(password2)) {
			return passLength(password2);
		}
		return false;
	}
	
	
	//氏名必須入力チェック
	private boolean nameEmpty(String str) {
		str = str != null? str: "";
		if (str.isEmpty()) {
			errors.add("氏名を入力して下さい。");
			return false;
		}
		return true;
	}
	
	//氏名長さチェック
	private boolean nameLength(String str) {
		str = str != null? str: "";
		if (str.length() > 20) {
			errors.add("氏名の指定が長すぎます。");
			return false;
		}
		return true;
	}
	
	//メールアドレス必須入力チェック
		private boolean mailEmpty(String str) {
			str = str != null? str: "";
			if (str.isEmpty()) {
				errors.add("メールアドレスを入力して下さい。");
				return false;
			}
			return true;
		}
	
	//メールアドレス長さチェック
	private boolean mailLength(String str) {
		str = str != null? str: "";
		if (str.length() > 100) {
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
		str = str != null? str: "";
		if (str.isEmpty()) {
			errors.add("パスワードを入力して下さい。");
			return false;
		}
		return true;
	}
	
	//パスワード長さチェック
	private boolean passLength(String str) {
		str = str != null? str: "";
		if (str.length() > 30) {
			errors.add("パスワードが長すぎます。");
			return false;
		}
		return true;
	}
	
	//パスワード（確認）必須入力チェック
	private boolean passCheckEmpty(String str) {
		str = str != null? str: "";
		if (str.isEmpty()) {
			errors.add("パスワード（確認）を入力して下さい。");
			return false;
		}
		return true;
	}
		
	//パスワード等値チェック
	private boolean passSame1(String str1,String str2) {
		if (!(str1.equals(str2))) {
			errors.add("パスワードとパスワード（確認）の入力内容が異なっています。");
			return false;
		}
		return true;
	}
		
	//パスワード一致チェック
	private boolean passSame2(String str1,String str2) {
		if (!(str1.equals(str2))) {
			errors.add("パスワードとパスワード（確認）が一致していません。");
			return false;
		}
		return true;
	}
	
	
	//メールアドレス重複チェック
	private boolean mailDuplication(String mail) {
		String sql = "select count(*) from accounts where mail = ?";
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("count(*)") > 0) {
					errors.add("すでに登録されているメールアドレスです");
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	

}

//まだできてないやつ
//バリデート分ける必要があれば分ける
