package validation;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.EmailValidator;

import lombok.Getter;
import model.beans.AccountsBean;
import util.DbUtil;
@Getter
public class LoginFormCheck {
	
	private ArrayList<String> errors = new ArrayList<>();
	private AccountsBean account;
	private ArrayList<AccountsBean> list = new ArrayList<>();

	public boolean validate(HttpServletRequest req) {

		if (mailCheck(req.getParameter("mail")) & passCheck(req.getParameter("password"))) {
			if (accountExist(req.getParameter("mail")))
					return passSame(req.getParameter("password")) && hashPassCheck(req.getParameter("password"));
		}
		return false;
		
	}
	
	
	private boolean mailCheck(String str) {
		if (mailEmpty(str)) {
			return mailLength(str) & mailFormat(str);
		}
		return false;
	}
	
	
	private boolean passCheck(String str) {
		if (passEmpty(str))
			return passLength(str);
		return false;
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
			errors.add("メールアドレスが長すぎます。");
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
	        	errors.add("メールアドレスを正しく入力して下さい");
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
	
	//アカウントテーブル存在チェック
	//インスタンス変数（クラス自身が持つ変数）にArrayListを追加して、複数のメールアドレスがあっても対応。
	private boolean accountExist(String str) {
		String sql = "select * from accounts where authority != 4 and mail = ?";
		boolean result = false;
		try( 
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("name") != null) {
					AccountsBean ab = new AccountsBean(
							rs.getInt("account_id"), 
							rs.getString("name"), 
							rs.getString("mail"),
							rs.getString("password"),
							rs.getString("authority")
							);
					list.add(ab);
					result = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (!result)
			errors.add("アカウントが存在しません。");
		return result;
		
	}
		
	//パスワードチェック
	private boolean passSame(String str1) {
		boolean result = false;
		for (AccountsBean ab: list) {
			if (ab == null) {
				return false;
			}
			if (str1.equals(ab.getPassword())) {
				account = ab;
				result = true;
			}
		}
		
		if (!result) {
			errors.add("メールアドレス、パスワードを正しく入力して下さい。");
		}
		return result;
	}
	
	
	private boolean hashPassCheck(String str) {
		String sql = "select * from hash where account_id = ?";
		
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			for (int i = 0; i < list.size(); i++) {
				ps.setInt(1, list.get(i).getAccount_id() );
				ResultSet rs = ps.executeQuery();
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				while (rs.next()) {
					String salt = rs.getString("salt");
					String hash = str + salt;
					md.update(hash.getBytes());
					byte[] hashBytes = md.digest();
					String hashpassword = Base64.getEncoder().encodeToString(hashBytes);
					
					if (hashpassword.equals(rs.getString("hashpassword"))) {
						account = list.get(i);
						return true;
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ハッシュ化がうまくいってません");
		return false;
	}
	
}
	
	

