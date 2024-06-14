package validation;

import org.apache.commons.validator.routines.EmailValidator;

public class AdressCheckTest {
	public static void main(String[] args) {
		
		String value = "test//@gmail.com";
		
		boolean result = false;
		
	    if (value != null) {
	        if(EmailValidator.getInstance().isValid(value)) {
	            result = true;
	        }
	    }
	   System.out.println(result);
		
	}
	
	
}
