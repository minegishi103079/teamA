package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import util.CommonUtil;
import util.DbUtil;

public class Sales_formcheck {
	
	public static void main(String[] args) {
		
		
		
		System.out.println(accountExist("0"));
	}
	static ArrayList<String> errors = new ArrayList<>();
	
	public boolean validate(HttpServletRequest req) {
		
		boolean a = dateEmpty("a");
		boolean b = accountEmpty("b");
		
		boolean result = a && b;
		
		return result;
	}
	
	//販売日必須入力チェック
	private boolean dateEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("販売日を入力して下さい。");
			return false;
		}
		return true;
	}
	
	//販売日形式チェック
	private static boolean dateFormat(String str) {
		try {
			CommonUtil.str_LocalDate(str);
			
			} catch (Exception e) {
				errors.add("販売日を正しく入力して下さい。");
				return false;
		    }
		return true;

	}
	

	//担当必須入力チェック
	private boolean accountEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("担当が未選択です。");
			return false;
		}
		return true;
	}

	
	//商品カテゴリー必須入力チェック
	private boolean categoryEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("商品カテゴリーが未選択です。");
			return false;
		}
		return true;
	}
	
	//商品名必須入力チェック
	private boolean nameEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("商品名を入力してください。");
			return false;
		}
		return true;
	}
	
	
	
	//商品名長さチェック
	private boolean nameLength(String str) {
		if(str.length() > 100) {
			errors.add("商品名が長すぎます。");
			return false;
		}
		return true;
	}
	
	//単価必須入力チェック
	private boolean priceEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("単価を入力してください。");
			return false;
		}
		return true;
	}
	
	
	//単価長さチェック
	private boolean priceLength(String str) {
		if(str.length() > 10) {
			errors.add("単価が長すぎます。");
			return false;
		}
		return true;
	}
	
	//単価形式チェック
	private boolean priceFormat(String str) {
		 try {
		        Integer.parseInt(str);
		    } catch (NumberFormatException e) {
		    	errors.add("単価を正しく入力してください。");
				return false;
		    }
		 return true;
	}
	
	
	//個数必須入力チェック
	private boolean saleNumberEmpty(String str) {
		if(str.isEmpty()) {
			errors.add("個数を入力してください。");
			return false;
		}
		return true;
	}
		
	
	//個数長さチェック
	private boolean saleNumberLength(String str) {
		if(str.length() > 10) {
			errors.add("個数が長すぎます。");
			return false;
		}
		return true;
	}
	
	//個数形式チェック
	private boolean saleNumberFormat(String str) {
		 try {
		        Integer.parseInt(str);
		    } catch (NumberFormatException e) {
		    	errors.add("個数を正しく入力してください。");
				return false;
		    }
		 return true;
	}
	
	
	
	//備考長さチェック
	private boolean noteLength(String str) {
		if(str.length() > 400) {
			errors.add("備考が長すぎます。");
			return false;
		}
		return true;
	}
	
	//アカウントテーブル存在チェック
	public static boolean accountExist(String str) {
		
		String sql = "select count(*) from sales where account_id =?"; 
		
		try(Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);){
				
				ps.setString(1, str);
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				if(rs.getInt("count(*)")==0) {
					errors.add("アカウントテーブルに存在しません。");
					return false;
					
					
				}
				
			}catch(SQLException e) {
				errors.add("アカウントテーブルに存在しません。");
				return false;
			}
			return true;
		
	}
	
	//商品カテゴリーテーブル存在チェック
	public static boolean categoryExist(String str) {
		
		String sql = "select count(*) from sales where category_id =?"; 
		
		try(Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);){
				
				ps.setString(1, str);
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				if(rs.getInt("count(*)")==0) {
					errors.add("商品カテゴリーに存在しません。");
					return false;
					
					
				}
				
			}catch(SQLException e) {
				errors.add("商品カテゴリーに存在しません。");
				return false;
			}
			return true;
		
	}
	
	
	
	//販売日形式（検索開始日）チェック
	private static boolean dateStartFormat(String str) {
		try {
			CommonUtil.str_LocalDate(str);
			
			} catch (Exception e) {
				errors.add("販売日を正しく入力して下さい。");
				return false;
		    }
		return true;

	}
	
	//販売日形式（検索終了日）チェック
	private static boolean dateEndFormat(String str) {
		try {
			CommonUtil.str_LocalDate(str);
			
			} catch (Exception e) {
				errors.add("販売日を正しく入力して下さい。");
				return false;
		    }
		return true;

	}
	
	
	//件数チェック
public static boolean numberCheck(String d1,String d2, String a,String c, String t, String n) {
		
		String sql = "select * from sales where saledate between ? and ? and account_id=? and category_id =? and trade_name like '%?%' and note like '%?%'"; 
		
		try(Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);){
				
				ps.setString(1, d1);
				ps.setString(2, d2);
				ps.setString(3, a);
				ps.setString(4, c);
				ps.setString(5, t);
				ps.setString(6, n);
				
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				if(rs.getInt("count(*)")==0) {
					errors.add("検索結果はありません。");
					return false;
					
					
				}
				
			}catch(SQLException e) {
				errors.add("検索結果はありません。");
				return false;
			}
			return true;
		
	}
	
	
	
	
	
	
}


//まだできてないやつ
//・件数チェック



