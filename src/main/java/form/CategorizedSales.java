package form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CategorizedSales {
	
	private int category_id;
	private String category_name;
	private int sum;
	
}
