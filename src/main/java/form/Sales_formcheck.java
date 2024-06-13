package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import util.CommonUtil;
import util.DbUtil;

@Getter

public class Sales_formcheck {

	private ArrayList<String> errors = new ArrayList<>();

	public boolean validate(HttpServletRequest req) {

		boolean a = dateEmpty(req.getParameter("sale_date"));
		boolean b = dateFormat(req.getParameter("sale_date"));
		boolean c = accountEmpty(req.getParameter("account_id"));
		boolean d = categoryEmpty(req.getParameter("category_id"));
		boolean e = nameEmpty(req.getParameter("trade_name"));
		boolean f = nameLength(req.getParameter("trade_name"));
		boolean g = priceEmpty(req.getParameter("unit_price"));
		boolean h = priceFormat(req.getParameter("unit_price"));
		boolean i = priceLength(req.getParameter("unit_price"));
		boolean j = saleNumberEmpty(req.getParameter("sale_number"));
		boolean k = saleNumberFormat(req.getParameter("sale_number"));
		boolean l = saleNumberLength(req.getParameter("sale_number"));
		boolean m = noteLength(req.getParameter("note"));
		boolean n = accountExist(req.getParameter("account_id"));
		boolean o = categoryExist(req.getParameter("category_id"));

		boolean result = a && b && c && d && e && f && g && h && i && j && k && l && m && n && o;

		return result;
	}

	public boolean validate_2(HttpServletRequest req) {

		boolean p = dateStartFormat(req.getParameter("date1"));
		boolean q = dateEndFormat(req.getParameter("date2"));
		boolean r = numberCheck(req);

		boolean result = p && q && r;

		return result;

	}

	//販売日必須入力チェック
	private boolean dateEmpty(String str) {
		if (str.isEmpty()) {
			errors.add("販売日を入力して下さい。");
			return false;
		}
		return true;
	}

	//販売日形式チェック
	private boolean dateFormat(String str) {
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
		if (str.isEmpty()) {
			errors.add("担当が未選択です。");
			return false;
		}
		return true;
	}

	//商品カテゴリー必須入力チェック
	private boolean categoryEmpty(String str) {
		if (str.isEmpty()) {
			errors.add("商品カテゴリーが未選択です。");
			return false;
		}
		return true;
	}

	//商品名必須入力チェック
	private boolean nameEmpty(String str) {
		if (str.isEmpty()) {
			errors.add("商品名を入力してください。");
			return false;
		}
		return true;
	}

	//商品名長さチェック
	private boolean nameLength(String str) {
		if (str.length() > 100) {
			errors.add("商品名が長すぎます。");
			return false;
		}
		return true;
	}

	//単価必須入力チェック
	private boolean priceEmpty(String str) {
		if (str.isEmpty()) {
			errors.add("単価を入力してください。");
			return false;
		}
		return true;
	}

	//単価長さチェック
	private boolean priceLength(String str) {
		if (str.length() > 10) {
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
		if (str.isEmpty()) {
			errors.add("個数を入力してください。");
			return false;
		}
		return true;
	}

	//個数長さチェック
	private boolean saleNumberLength(String str) {
		if (str.length() > 10) {
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
		if (str.length() > 400) {
			errors.add("備考が長すぎます。");
			return false;
		}
		return true;
	}

	//アカウントテーブル存在チェック
	public boolean accountExist(String str) {

		String sql = "select count(*) from sales where account_id =?";

		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();

			rs.next();
			if (rs.getInt("count(*)") == 0) {
				errors.add("アカウントテーブルに存在しません。");
				return false;

			}

		} catch (SQLException e) {
			errors.add("アカウントテーブルに存在しません。");
			return false;
		}
		return true;

	}

	//商品カテゴリーテーブル存在チェック
	public boolean categoryExist(String str) {

		String sql = "select count(*) from sales where category_id =?";

		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();

			rs.next();
			if (rs.getInt("count(*)") == 0) {
				errors.add("商品カテゴリーに存在しません。");
				return false;

			}

		} catch (SQLException e) {
			errors.add("商品カテゴリーに存在しません。");
			return false;
		}
		return true;

	}

	//販売日形式（検索開始日）チェック
	private boolean dateStartFormat(String str) {
		if (str != "") {
			try {
				CommonUtil.str_LocalDate(str);

			} catch (Exception e) {
				errors.add("販売日を正しく入力して下さい。");
				return false;
			}
		}
		return true;

	}

	//販売日形式（検索終了日）チェック
	private boolean dateEndFormat(String str) {
		if (str != "") {
			try {
				CommonUtil.str_LocalDate(str);

			} catch (Exception e) {
				errors.add("販売日を正しく入力して下さい。");
				return false;
			}
		}
		return true;

	}

	//件数チェック
	public boolean numberCheck(HttpServletRequest request) {
		String sql = "select count(*) from sales s ";
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String account = request.getParameter("account_id");
		String category = request.getParameter("category_id");
		String trade = request.getParameter("trade_name");
		String note = request.getParameter("note");

		sql += "where sale_date >= '" + date1 + "' ";
		if (!date2.isEmpty())
			sql += "and sale_date <= '" + date2 + "' ";
		if (!account.isEmpty())
			sql += "and account_id = '" + account + "' ";
		if (!category.isEmpty())
			sql += "and category_id = '" + category + "' ";
		sql += "and trade_name like '%" + trade + "%' ";
		sql += "and note like '%" + note + "%' ";

		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			rs.next();

			if (rs.getInt("count(*)") == 0) {
				errors.add("検索結果はありません。");
				return false;

			}

		} catch (SQLException e) {
			errors.add("検索結果はありません。");
			return false;
		}
		return true;
	}
}
