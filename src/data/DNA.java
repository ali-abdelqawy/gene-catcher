package data;

import java.util.HashMap;

public class DNA {
	final static String startCodon = "ATG";
	final static String[] stopCodons = {"TAA", "TAG", "TGA"};
	final static int codonLength = 3;
	
	public static HashMap<String, String> getStrandsByFiles(String folderName) {
		Fetcher fetcher = new Fetcher(folderName);
		return fetcher.getFilesContent();
	}
	
	public static String getStartCodon() {
		return startCodon;
	}
	
	public static String[] getStopCodons() {
		return stopCodons;
	}
}
