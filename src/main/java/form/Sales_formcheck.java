package form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Sales_formcheck {
	ArrayList<String> errors = new ArrayList<>();
	
	public boolean validate(HttpServletRequest req) {
		
		boolean a = dateEmpty("a");
		boolean b = accountEmpty("b");
		
		boolean result = a && b;
		
		return result;
	}
	
	//販売日必須入力チェック
	private boolean dateEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("販売日を入力してください");
			return false;
		}
		return true;
	}

	//担当必須入力チェック
	private boolean accountEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("担当が未選択です");
			return false;
		}
		return true;
	}

	
	//商品カテゴリー必須入力チェック
	private boolean categoryEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("商品カテゴリーが未選択です");
			return false;
		}
		return true;
	}
	
	//商品名必須入力チェック
	private boolean nameEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("商品名を入力してください");
			return false;
		}
		return true;
	}
	
	
	
	//商品名長さチェック
	private boolean nameLength(String str) {
		if(str.length() > 100) {
			errors.add("商品名が長すぎます");
			return false;
		}
		return true;
	}
	
	//単価必須入力チェック
	private boolean priceEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("単価を入力してください");
			return false;
		}
		return true;
	}
	
	
	//単価長さチェック
	private boolean priceLength(String str) {
		if(str.length() > 10) {
			errors.add("単価が長すぎます");
			return false;
		}
		return true;
	}
	
	//個数必須入力チェック
	private boolean saleNumberEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("個数を入力してください");
			return false;
		}
		return true;
	}
		
	
	//個数長さチェック
	private boolean saleNumberLength(String str) {
		if(str.length() > 10) {
			errors.add("個数が長すぎます");
			return false;
		}
		return true;
	}
	
	//備考長さチェック
	private boolean noteLength(String str) {
		if(str.length() > 400) {
			errors.add("備考が長すぎます");
			return false;
		}
		return true;
	}
	
	
}


//まだできてないやつ
//・販売日形式チェック
//・個数形式チェック
//・アカウントテーブル存在チェック
//s0010,s0020
//・商品カテゴリーテーブル存在チェック
//s0010,s0020
//
//・販売日形式（検索開始日）チェック
//・販売日形式（検索終了日）チェック
//・件数チェック



