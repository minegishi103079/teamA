package model.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AccountsBean {
	private int account_id;
	private String name;
	private String mail;
	private String password;
	private String authority;
	
	//authorityをintからStringに変更しました
	
}
