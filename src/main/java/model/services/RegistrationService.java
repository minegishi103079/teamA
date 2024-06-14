package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.AccountsBean;
import model.beans.CategoriesBean;
import util.DbUtil;

public class RegistrationService {
	public ArrayList<AccountsBean> accounts(){
		String sql="select * from accounts";
		ArrayList<AccountsBean>ab=new ArrayList<>();
		//try-with-resources
		//()内のリソースを自動的にクローズする
		try (
			Connection con=DbUtil.open();
			PreparedStatement stmt = con.prepareStatement(sql);
		){
			//PreparedStatementがクローズされるタイミングでクローズ
			ResultSet rs =stmt.executeQuery();
			while(rs.next()) {
				AccountsBean ac=new AccountsBean(
						rs.getInt("account_id"),
						rs.getString("name"),
						rs.getString("mail"),
						rs.getString("password"),
						rs.getString("authority")
						);
				ab.add(ac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return ab;
		
	}
	
	public ArrayList<CategoriesBean> categories(){
		String sql="select * from categories";
		ArrayList<CategoriesBean>cb=new ArrayList<>();
		//try-with-resources
		//()内のリソースを自動的にクローズする
		try (
			Connection con=DbUtil.open();
			PreparedStatement stmt = con.prepareStatement(sql);
		){
			//PreparedStatementがクローズされるタイミングでクローズ
			ResultSet rs =stmt.executeQuery();
			while(rs.next()) {
				CategoriesBean cg=new CategoriesBean(
						rs.getInt("category_id"),
						rs.getString("Category_name"),
						rs.getInt("active_flg")
						);
				cb.add(cg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return cb;
	}
	
	public String accountsname(String accountid) {
		String sql="select name from accounts where account_id=?";
		String ai=null;
		try (
				Connection con=DbUtil.open();
				PreparedStatement stmt = con.prepareStatement(sql);
			){
				//PreparedStatementがクローズされるタイミングでクローズ
			stmt.setString(1, accountid);	
			ResultSet rs =stmt.executeQuery();
				while(rs.next()) {
					ai=rs.getString("name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}return ai;
	}
	
	public String categoryname(String categoryid) {
		String sql="select category_name from categories where category_id=?";
		String ci=null;
		try (
				Connection con=DbUtil.open();
				PreparedStatement stmt = con.prepareStatement(sql);
			){
				//PreparedStatementがクローズされるタイミングでクローズ
			stmt.setString(1, categoryid);	
			ResultSet rs =stmt.executeQuery();
				while(rs.next()) {
					ci=rs.getString("category_name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}return ci;
	}
}
