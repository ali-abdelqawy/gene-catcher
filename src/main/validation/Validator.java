package main.validation;

import main.errors.ErrorGenerator;
import main.input.DNA;

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
	
	public static boolean isGeneValid(int geneStart, int stopCodonIndex) {
		int distance = stopCodonIndex - geneStart;
		return distance % DNA.codonLength == 0;
	}
}
