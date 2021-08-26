package main.validation;

public class StringValidator {
	public static boolean isEmpty(String s) {
		return (s == null || s.isEmpty() || s.isBlank()) ? true : false;
	}
}
