package main.validation;

public class Validator {
	
	public static boolean isStringEmpty(String s) {
		return (s == null || s.isEmpty() || s.isBlank()) ? true : false;
	}
	
}
