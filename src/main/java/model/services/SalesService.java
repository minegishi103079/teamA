package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.beans.ListBean;
import model.beans.SearchResultBean;
import util.CommonUtil;
import util.DbUtil;

public class SalesService {
	

	
	
	
	public static void main(String[] args) {
		
	}
	
	// 詳細画面に必要なデータを取り出す。結果はListBeanの形で渡す
	public ListBean salesDetailSales(String sale_id) {
		String sql = "SELECT * FROM sales s "
				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id "
				+ "WHERE sale_id = ?";	// 担当・カテゴリーの名前は別テーブルなのでleft joinする。sale_idで一意に定める
		ListBean sales = null;
		
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, sale_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sales = new ListBean(
						rs.getInt("sale_id"), 
						CommonUtil.str_LocalDate(rs.getString("sale_date") ), 
						rs.getInt("account_id"), 
						rs.getInt("category_id"), 
						rs.getString("trade_name"), 
						rs.getInt("unit_price"), 
						rs.getInt("sale_number"), 
						rs.getString("note"),
						rs.getString("name"),
						rs.getString("category_name")
						);
			};
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sales;
	}
	
	
	// saleの中身をアカウント・カテゴリーとつなげて全部出す。
	public ArrayList<ListBean> salesSelectAll() {
		String sql = "SELECT * FROM sales s "
		+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
		+ "LEFT JOIN categories c ON s.category_id = c.category_id";
		
		return salesResultAllList(sql);
	}
	
	
	// 検索結果のrequestを受け取って、当てはまるデータをArrayListで返す
	public ArrayList<ListBean> salesSearchResult(HttpServletRequest request){
		String sql = "select * from sales s "
				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id ";
		
		// 条件に当てはまるデータを絞り込むために、whereで記述すべきことを追加していく。
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String account = request.getParameter("account_id");
		String category = request.getParameter("category_id");
		String trade = request.getParameter("trade_name");
		String note = request.getParameter("note");
		// 何もないとき（''）にエラーが出るものは、空白ではsqlに追加しないようにする。
		sql += "where sale_date >= '"+ date1 +"' ";
		if (!date2.isEmpty())
			sql += "and sale_date <= '"+ date2 +"' ";
		if (!account.isEmpty())
			sql += "and account_id = '"+ account +"' ";
		if (!category.isEmpty())
			sql += "and category_id = '"+ category +"' ";
		sql += "and trade_name like '%"+ trade +"%' ";
		sql += "and note like '%"+ note+"%' ";
		
		// 完成したsqlを実行してもらって、ArrayListを受け取る。
		return salesResultAllList(sql);
		
	}
	
	
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
		sql += "where sale_date >= '"+ date1 +"' ";
		if (!date2.isEmpty())
			sql += "and sale_date <= '"+ date2 +"' ";
		if (!account.isEmpty())
			sql += "and s.account_id = '"+ account +"' ";
		if (!category.isEmpty())
			sql += "and s.category_id = '"+ category +"' ";
		sql += "and trade_name like '%"+ trade +"%' ";
		sql += "and note like '%"+ note+"%' ";
		
		
		return salesResultAllList(sql);
	}
	
	
	
	ArrayList<ListBean> salesResultAllList(String sql) {
		ArrayList<ListBean> list = new ArrayList<>();
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ListBean sales = new ListBean(
						rs.getInt("sale_id"), 
						CommonUtil.str_LocalDate(rs.getString("sale_date") ), 
						rs.getInt("account_id"), 
						rs.getInt("category_id"), 
						rs.getString("trade_name"), 
						rs.getInt("unit_price"), 
						rs.getInt("sale_number"), 
						rs.getString("note"),
						rs.getString("name"),
						rs.getString("category_name")
						);
				list.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void salesUpdate(HttpServletRequest request) {
		SaleService_2 s2 = new SaleService_2();
		try {
			s2.salesUpdate(request.getParameter("sale_date"), 
					CommonUtil.str_Int(request.getParameter("account_id")), 
					CommonUtil.str_Int(request.getParameter("category_id")), 
					request.getParameter("trade_name"), 
					CommonUtil.str_Int(request.getParameter("unit_price")), 
					CommonUtil.str_Int(request.getParameter("sale_number")), 
					request.getParameter("note"), 
					CommonUtil.str_Int(request.getParameter("sale_id")) 
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
