package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.beans.SalesBean;
import util.CommonUtil;
import util.DbUtil;

public class SaleService_2 {
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
			ps.setInt(6, bean.getSale_id());
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
			ps.setInt(6, bean.getSale_id());
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
