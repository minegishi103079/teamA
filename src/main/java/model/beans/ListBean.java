package model.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ListBean {
	
	private int sale_id;
	private LocalDate sale_date;
	private int account_id;
	private int category_id;
	private String trade_name;
	private int unit_price;
	private int sale_number;
	private String note;
	private String name;
	private int authority;
	private String category_name;
	private int active_flg;
	
	
}
