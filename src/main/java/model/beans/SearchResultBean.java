package model.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SearchResultBean {
	
	private String date1;
	private String date2;
	private String account;
	private String category;
	private String trade;
	private String note;
	
}
