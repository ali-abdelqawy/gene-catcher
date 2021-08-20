package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Holder {
	private String folderName = "";
    HashMap<String, String> strands = new HashMap<>();
	
	public Holder(String folderName) {
		if (!folderName.isEmpty() && !folderName.isBlank()) {
			this.folderName = folderName;
			setDNAs();
		}
		else
			System.err.println("You must specify the folder name");
	}
	public String[] loadDNAsFiles() {
		String[] DNAsFiles = Fetcher.readAllFiles(folderName);
		if (DNAsFiles == null) {
			System.err.println("Invalid folder name");
			return null;
		}
	
		return DNAsFiles;		
	}
	
	private ArrayList<String> loadStrands(String[] DNAsFiles) {
		ArrayList<String> strands = new ArrayList<String>(0);
		for (String DNAFile : DNAsFiles) {
			String DNA = Fetcher.fileToString(folderName + "/" + DNAFile);
			strands.add(DNA);
		}
		return strands;
	}
	
	private void setDNAs() {
		String[] DNAsFiles = loadDNAsFiles();
		ArrayList<String> strands = loadStrands(DNAsFiles);
		for (int i = 0; i < DNAsFiles.length; i++) {
			this.strands.put(DNAsFiles[i], strands.get(i));
		}
	}
	
	public HashMap<String, String> getDNAs() {
		return this.strands;
	}
	
}
