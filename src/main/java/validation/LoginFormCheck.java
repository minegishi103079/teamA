package validation;

import java.security.MessageDigest;
import java.security.SecureRandom;
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

	public boolean validate(HttpServletRequest req) {


		boolean c = mailEmpty(req.getParameter("mail"));
		boolean d = mailLength(req.getParameter("mail"));
		boolean e = mailFormat(req.getParameter("mail"));
		boolean f = passEmpty(req.getParameter("password"));
		boolean g = passLength(req.getParameter("password"));
		boolean h = accountExist(req.getParameter("mail"));
		boolean i = passSame(req.getParameter("password"));
//		boolean i = hashPassCheck(req.getParameter("password"));

		boolean result =  c && d && e && f && g && h && i ;

		return result;
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
		if (str.length() > 30) {
			errors.add("パスワードが長すぎます。");
			return false;
		}
		return true;
	}
	
	//アカウントテーブル存在チェック
	private boolean accountExist(String str) {
		String sql = "select *, count(*) from accounts where mail = ?";
		
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
		errors.add("アカウントが存在しません。");
		return false;
		
		
	}
		
	//パスワードチェック
	private boolean passSame(String str1) {
		if (account == null) {
			return false;
		}
		if (!( str1.equals( account.getPassword() ) )) {
			errors.add("メールアドレス、パスワードを正しく入力して下さい。");
			return false;
		}
		return true;
	}
	
	private static void hash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] salt = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);
            md.update(salt);
			md.update(password.getBytes());
		    byte[] hashBytes = md.digest();
		    String hashpass = Base64.getEncoder().encodeToString(hashBytes);
		    System.out.println(hashpass);
//		    StringBuffer sb = new StringBuffer();
//			byte[] cipherBytes = md.digest(password.getBytes());
//
//			for (int i=0; i<cipherBytes.length; i++) {
//				sb.append(String.format("%02x", cipherBytes[i]&0xff));
//			}
//		    System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean hashPassCheck(String str) {
		String sql = "select * from hash where account_id = ?";
		
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, account.getAccount_id());
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String salt = rs.getString("salt");
			String hash = str + salt;
			md.update(hash.getBytes());
		    byte[] hashBytes = md.digest();
		    String hashpassword = Base64.getEncoder().encodeToString(hashBytes);
		    
		    if (hashpassword.equals(rs.getString("hashpassword"))) {
		    	return true;
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ハッシュ化がうまくいってません");
		return false;
	}
	
}
	
	

