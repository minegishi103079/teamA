package model.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SalesBean {
	
	public SalesBean(String date, int ai, int ci, String tn, int up, int sn, String n) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	private int sale_id;
	private LocalDate sale_date;
	private int account_id;
	private int category_id;
	private String trade_name;
	private int unit_price;
	private int sale_number;
	private String note;
	
}
