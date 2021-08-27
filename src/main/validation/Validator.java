package main.validation;

import main.errors.ErrorGenerator;

public class Validator {
	
	public static boolean isStringEmpty(String s) {
		if (s == null)
			return true;
		
		return s.isEmpty() ? true : false;
	}
	
	public static boolean isFolderNameValid(String folderName) {
		folderName = folderName.trim();
		if (isStringEmpty(folderName)) {
			ErrorGenerator.printError(ErrorGenerator.getEmptyFolderNameError());
			return false;
		}
		return true;
	}
}
