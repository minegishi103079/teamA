package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.CommonUtil;
import util.DbUtil;

public class AccountsService_2 {
	
	//アカウント追加
	public void salesinsert(String na,String ma, String pa, int au) {
		String sql = "INSERT into accounts(name,mail,password,authority) VALUES(?,?,?,?)";
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, na);
			ps.setString(2, ma);
			ps.setString(3, pa);
			ps.setInt(4, au);
			

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//アカウント更新
	public void salesupdate(String na,String ma, String pa, int au) {
		String sql = "update accounts set name=?,mail=?,password=?,authority=? where account_id=?";
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, na);
			ps.setString(2, ma);
			ps.setString(3, pa);
			ps.setInt(4, au);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//アカウント削除
	public void salesdelete(String id) {
		String sql = "delete from accounts where account_id = ?";
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, CommonUtil.str_Int(id));

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
