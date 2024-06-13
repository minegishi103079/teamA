package form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Accounts_formCheck {
	private ArrayList<String> errors = new ArrayList<>();

	public boolean validate(HttpServletRequest req) {

		boolean a = nameEmpty(req.getParameter());
		boolean b = nameLength(req.getParameter());
		boolean c = mailEmpty(req.getParameter());
		boolean d = mailLength(req.getParameter());
		boolean e = (req.getParameter());
		boolean f = passEmpty(req.getParameter());
		boolean g = passLength(req.getParameter());
		boolean h = passCheckEmpty(req.getParameter());
		boolean i = (req.getParameter());

		boolean result = a && b && c && d && e && f && g && h && i;

		return result;
	}
	
	//氏名必須入力チェック
	private boolean nameEmpty(String str) {
		if (str.isEmpty()) {
			errors.add("氏名を入力して下さい。");
			return false;
		}
		return true;
	}
	
	//氏名長さチェック
	private boolean nameLength(String str) {
		if (str.length() > 100) {
			errors.add("氏名の指定が長すぎます。");
			return false;
		}
		return true;
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
	
	//パスワード（確認）必須入力チェック
	private boolean passCheckEmpty(String str) {
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

}

//まだできてないやつ
//メールアドレス形式チェック

//パラメータの中身
//バリデート分ける必要があれば分ける
