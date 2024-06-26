package validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		boolean c = password1Check(req.getParameter("password1"),req.getParameter("password2"));

		boolean result = a && b && c ;
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
		boolean b = mailCheck2(req.getParameter("mail"));
		boolean c = password2Check(req.getParameter("password1"), req.getParameter("password2"));

		boolean result = a && b && c;

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
				return mailLength(mail)&mailFormat(mail)&mailDuplication(mail);
		}
		return false;
	}
	
	private boolean mailCheck2(String mail) {
		if(mailEmpty(mail)) {
				return mailLength(mail)&mailFormat2(mail);
		}
		return false;
	}
	
	private boolean password1Check(String password1,String password2) {
		if(passEmpty(password1) &passCheckEmpty(password2)) {
			return passLength(password1) & passSame1(password1, password2)& password(password1);
		}
		return false;
	}
	
	private boolean password2Check(String password1,String password2) {
		if(passEmpty(password1) &passCheckEmpty(password2)) {
			return passLength(password1) & passSame2(password1, password2)&password(password1);
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
			errors.add("氏名が長すぎます。");
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
	        	errors.add("メールアドレスを正しく入力して下さい。");
	        	return false;
	        }
	        
	    }
		return false;
		
	}
	//メールアドレス形式チェック
		private boolean mailFormat2(String str) {
			
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
		if (str.length() < 8 | str.length() > 30) {
			errors.add("パスワードは8文字以上30文字以内にして下さい。");
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
	
	//パスワードの正規表現のやつ
	private boolean password(String password) {
		Pattern pattern1 = Pattern. compile("^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])|(?=.*[a-z])(?=.*[A-Z])(?=.*[!@;:])|(?=.*[A-Z])(?=.*[0-9])(?=.*[!@;:])|(?=.*[a-z])(?=.*[0-9])(?=.*[!@;:]))([a-zA-Z0-9!@;:])*");	
	
		 
		// チェック対象文字列をMatcherに格納します
		Matcher matcher1 = pattern1.matcher(password);
		 
		// 判定結果を取得します
		if (!(matcher1.matches())) {
			errors.add("英大文字・英小文字・数字・記号(!@;:)の4種類の文字種のうち3種類を含むパスワードにして下さい。");
			return false;
		}
		return true;
	}
}
