package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import form.CategorizedSales;
import form.ListBean;
import form.SearchResultBean;
import model.beans.SalesBean;
import util.CommonUtil;
import util.DbUtil;

public class SalesService {

	// 詳細画面に必要なデータを取り出す。結果はListBeanの形で渡す
	public ListBean salesDetailSales(String sale_id) {
		String sql = "SELECT * FROM sales s "
				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id "
				+ "WHERE sale_id = ?"; // 担当・カテゴリーの名前は別テーブルなのでleft joinする。sale_idで一意に定める
		ListBean sales = null;

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, sale_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sales = new ListBean(
						rs.getInt("sale_id"),
						CommonUtil.str_LocalDate(rs.getString("sale_date")),
						rs.getInt("account_id"),
						rs.getInt("category_id"),
						rs.getString("trade_name"),
						rs.getInt("unit_price"),
						rs.getInt("sale_number"),
						rs.getString("note"),
						rs.getString("name"),
						rs.getString("category_name"));
			}
			;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sales;
	}

	// saleの中身をアカウント・カテゴリーとつなげて全部出す。
//	public ArrayList<ListBean> salesSelectAll() {
//		String sql = "SELECT * FROM sales s "
//				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
//				+ "LEFT JOIN categories c ON s.category_id = c.category_id";
//
//		return salesResultAllList(sql);
//	}

	// 検索結果のrequestを受け取って、当てはまるデータをArrayListで返す
//	public ArrayList<ListBean> salesSearchResult(HttpServletRequest request) {
//		String sql = "select * from sales s "
//				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
//				+ "LEFT JOIN categories c ON s.category_id = c.category_id ";
//
//		// 条件に当てはまるデータを絞り込むために、whereで記述すべきことを追加していく。
//		String date1 = request.getParameter("date1");
//		String date2 = request.getParameter("date2");
//		String account = request.getParameter("account_id");
//		String category = request.getParameter("category_id");
//		String trade = request.getParameter("trade_name");
//		String note = request.getParameter("note");
//		// 何もないとき（''）にエラーが出るものは、空白ではsqlに追加しないようにする。
//		sql += "where sale_date >= '" + date1 + "' ";
//		if (!date2.isEmpty())
//			sql += "and sale_date <= '" + date2 + "' ";
//		if (!account.isEmpty())
//			sql += "and account_id = '" + account + "' ";
//		if (!category.isEmpty())
//			sql += "and category_id = '" + category + "' ";
//		sql += "and trade_name like '%" + trade + "%' ";
//		sql += "and note like '%" + note + "%' ";
//
//		// 完成したsqlを実行してもらって、ArrayListを受け取る。
//		return salesResultAllList(sql);
//
//	}

	// 検索結果をページをまたいで受け取るときに、編集などがあった場合にリストの形では渡せない（編集が適用されないため）
	// Sessionにはリクエストのデータを入れてあげる。一つ一つ記述するのは長くなるので、一つにまとめられるBeanに入れる。
	// それ以外は上記と同じ
	public ArrayList<ListBean> salesSearchResultList(SearchResultBean bean) {
		String sql = "select * from sales s "
				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id ";

		String date1 = bean.getDate1();
		String date2 = bean.getDate2();
		String account = bean.getAccount();
		String category = bean.getCategory();
		String trade = bean.getTrade();
		String note = bean.getNote();
		sql += "where sale_date >= '" + date1 + "' ";
		if (!date2.isEmpty())
			sql += "and sale_date <= '" + date2 + "' ";
		if (!account.isEmpty())
			sql += "and s.account_id = '" + account + "' ";
		if (!category.isEmpty())
			sql += "and s.category_id = '" + category + "' ";
		sql += "and trade_name like '%" + trade + "%' ";
		sql += "and note like '%" + note + "%' ";

		return salesResultAllList(sql);
	}

	ArrayList<ListBean> salesResultAllList(String sql) {
		ArrayList<ListBean> list = new ArrayList<>();

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ListBean sales = new ListBean(
						rs.getInt("sale_id"),
						CommonUtil.str_LocalDate(rs.getString("sale_date")),
						rs.getInt("account_id"),
						rs.getInt("category_id"),
						rs.getString("trade_name"),
						rs.getInt("unit_price"),
						rs.getInt("sale_number"),
						rs.getString("note"),
						rs.getString("name"),
						rs.getString("category_name"));
				list.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	public void salesUpdate(HttpServletRequest request) {
//		SaleService_2 s2 = new SaleService_2();
//		try {
//			s2.salesUpdate(CommonUtil.request_SalesBean(request));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public ArrayList<Integer> salesSelectMonthly() {
		String sql = "SELECT * FROM sales where sale_date between '2024-01-01' and '2024-12-31'";

		ArrayList<Integer> month = new ArrayList<>();
		int Jan = 0;
		int Feb = 0;
		int Mar = 0;
		int Apr = 0;
		int May = 0;
		int Jun = 0;
		int Jul = 0;
		int Aug = 0;
		int Sep = 0;
		int Oct = 0;
		int Nov = 0;
		int Dec = 0;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LocalDate date = CommonUtil.str_LocalDate(rs.getString("sale_date"));
				if (date.isBefore(LocalDate.of(2024, 2, 1))) {
					Jan += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 3, 1))) {
					Feb += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 4, 1))) {
					Mar += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 5, 1))) {
					Apr += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 6, 1))) {
					May += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 7, 1))) {
					Jun += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 8, 1))) {
					Jul += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 9, 1))) {
					Aug += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 10, 1))) {
					Sep += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 11, 1))) {
					Oct += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2024, 12, 1))) {
					Nov += rs.getInt("unit_price") * rs.getInt("sale_number");
				} else if (date.isBefore(LocalDate.of(2025, 1, 1))) {
					Dec += rs.getInt("unit_price") * rs.getInt("sale_number");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		month.addAll(Arrays.asList(Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec));
		
		
		return month;
	}
	
	public ArrayList<CategorizedSales> salesSelectCategory() {
		String sql = "SELECT s.category_id, c.category_name, sum(unit_price*sale_number) FROM sales s "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id  "
				+ "GROUP BY s.category_id ORDER BY s.category_id";
		
		ArrayList<CategorizedSales> list = new ArrayList<>();

		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategorizedSales cs = new CategorizedSales(
						rs.getInt("category_id"),
						rs.getString("category_name"),
						rs.getInt("sum(unit_price*sale_number)"));
				list.add(cs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	
	
	//売上追加
		public void salesInsert(SalesBean bean) {
			String sql = "INSERT into sales(sale_date,account_id,category_id,trade_name,unit_price,sale_number,note) VALUES(?,?,?,?,?,?,?)";
			try (Connection conn = DbUtil.open();
					PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setString(1,CommonUtil.localDateFormat(bean.getSale_date()) );
				ps.setInt(2, bean.getAccount_id());
				ps.setInt(3, bean.getCategory_id());
				ps.setString(4, bean.getTrade_name());
				ps.setInt(5, bean.getUnit_price());
				ps.setInt(6, bean.getSale_number());
				ps.setString(7, bean.getNote());

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//売上更新
		public void salesUpdate(SalesBean bean) {
			String sql = "update sales set sale_date=?,account_id=?,category_id=?,trade_name=?,unit_price=?,sale_number=?,note=? where sale_id=?";
			try (Connection conn = DbUtil.open();
					PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setString(1,CommonUtil.localDateFormat(bean.getSale_date()) );
				ps.setInt(2, bean.getAccount_id());
				ps.setInt(3, bean.getCategory_id());
				ps.setString(4, bean.getTrade_name());
				ps.setInt(5, bean.getUnit_price());
				ps.setInt(6, bean.getSale_number());
				ps.setString(7, bean.getNote());
				ps.setInt(8, bean.getSale_id());

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//売上削除
		public void salesDelete(String id) {
			String sql = "delete from sales where sale_id = ?";
			try (Connection conn = DbUtil.open();
					PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setInt(1, CommonUtil.str_Int(id));

				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

}
