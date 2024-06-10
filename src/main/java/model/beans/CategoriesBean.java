package model.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CategoriesBean {
	private int category_id;
	private String category_name;
	private int active_flg;
	
}
