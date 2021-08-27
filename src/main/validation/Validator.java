package main.validation;

public class Validator {
	
	public static boolean isStringEmpty(String s) {
		if (s == null)
			return true;
		
		return s.isEmpty() ? true : false;
	}
	
}
