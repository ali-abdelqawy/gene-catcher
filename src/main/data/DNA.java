package main.data;

import java.util.HashMap;

import main.errors.ErrorGenerator;
import main.validation.Validator;

public class DNA {
	final static String startCodon = "ATG";
	final static String[] stopCodons = {"TAA", "TAG", "TGA"};
	final static int codonLength = 3;
	int totalGenes = 0;
	
	public static HashMap<String, String> getStrandsByFiles(String folderName) {
		if (isFolderNameEmpty(folderName)) {
			ErrorGenerator.printError(ErrorGenerator.getEmptyFolderNameError());
			return null;
		}
		Fetcher fetcher = new Fetcher(folderName);
		return fetcher.getFilesContent();
	}
	
	public static String getStartCodon() {
		return startCodon;
	}
	
	public static String[] getStopCodons() {
		return stopCodons;
	}
	
	public static boolean isFolderNameEmpty(String folderName) {
		return Validator.isStringEmpty(folderName);
	}
	
}
