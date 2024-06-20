package model.services;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import model.beans.AccountsBean;
import util.CommonUtil;
import util.DbUtil;

public class AccountsService_2 {
	
	//アカウント追加
	public void accountsInsert(AccountsBean bean) {
		String sql = "INSERT into accounts(name,mail,password,authority) VALUES(?,?,?,?)";
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, bean.getName());
			ps.setString(2, bean.getMail() );
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getAuthority());

			ps.executeUpdate();
//			hashInsert(bean);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//アカウント更新
	public void accountsUpdate(AccountsBean bean) {
		String sql = "update accounts set name=?,mail=?,password=?,authority=? where account_id=?";
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setString(1, bean.getName());
			ps.setString(2, bean.getMail() );
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getAuthority());
			ps.setInt(5, bean.getAccount_id());
			

			ps.executeUpdate();
//			hashInsert(bean);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//アカウント削除
	public void accountsDelete(String id) {
		String sql = "delete from accounts where account_id = ?";
		try (Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, CommonUtil.str_Int(id));

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//アカウント一覧表示
	public ArrayList<AccountsBean> accountsSelectAll() {
		String sql = "SELECT * FROM accounts";
		
		return accountsResultAllList(sql);
	}
	
	//アカウント検索一覧表示
	ArrayList<AccountsBean> accountsResultAllList(String sql) {
		ArrayList<AccountsBean> list = new ArrayList<>();
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountsBean accounts = new AccountsBean(
						rs.getInt("account_id"), 
						rs.getString("name"),
						rs.getString("mail"),
						rs.getString("password"),
						rs.getString("authority")
						);
				list.add(accounts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<AccountsBean> searchResultList(AccountsBean bean) {
		String sql = "select * from accounts ";
		
		
		String name = bean.getName();
		String mail = bean.getMail();
		String authority = bean.getAuthority();
		
		sql += "where name like '%"+ name +"%'";	
		if (!mail.isEmpty())
			sql += "and mail = '"+ mail +"' ";
		if (authority != null)
			sql += "and authority = '"+ authority +"' ";
		
		
		return accountsResultAllList(sql);
	}
		
		
		// アカウント詳細
		public AccountsBean AccountsDetailSales(String account_id) {
			String sql = "SELECT * FROM accounts WHERE account_id = ?";
			AccountsBean accounts = null;
			
			
			try (
					Connection con = DbUtil.open();
					PreparedStatement ps = con.prepareStatement(sql);
			){
				ps.setString(1, account_id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					accounts = new AccountsBean(
							rs.getInt("account_id"), 
							rs.getString("name"), 
							rs.getString("mail"),
							rs.getString("password"),
							rs.getString("authority")
							);
				};
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return accounts;
		}
		
		
		
		private void hashInsert(AccountsBean bean) {
			String sql = "INSERT INTO hash (account_id, hashpassword, salt) "
					+ "VALUES (?, ?, ?)";
			try (Connection conn = DbUtil.open();
					PreparedStatement ps = conn.prepareStatement(sql);) {
				
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				SecureRandom random = new SecureRandom();
				String salt = String.valueOf(random.nextDouble());
				String hash = bean.getPassword() + salt;
				md.update(hash.getBytes());
			    byte[] hashBytes = md.digest();
			    String hashpassword = Base64.getEncoder().encodeToString(hashBytes);
				
			    String id = "";
			    if (bean.getAccount_id() == 0) {
			    	id = accountsSelectID(bean.getMail());
			    } else {
			    	id = String.valueOf(bean.getAccount_id());
			    }
				
				ps.setString(1, id );
				ps.setString(2, hashpassword );
				ps.setString(3, salt);

				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		private String accountsSelectID(String mail) {
			String sql = "select account_id from accounts where mail = ?";
			
			String id = "";
			try (
					Connection con = DbUtil.open();
					PreparedStatement ps = con.prepareStatement(sql);
			){
				ps.setString(1, mail);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					id = rs.getString("account_id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
		}
		
}


