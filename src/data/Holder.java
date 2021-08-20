package data;

import java.util.ArrayList;

public class Holder {
	private String folderName = "";
	private ArrayList<String> DNAs = new ArrayList<String>(0);
	
	public Holder(String folderName) {
		if (!folderName.isEmpty() && !folderName.isBlank()) {
			this.folderName = folderName;
			loadDNAsFiles();
		}
		else
			System.err.println("You must specify the folder name");
	}
	public void loadDNAsFiles() {
		String[] DNAsFiles = Fetcher.readAllFiles(folderName);
		if (DNAsFiles == null) {
			System.err.println("Invalid folder name");
			return;
		}
		setDNAs(DNAsFiles);
	}
	
	private void setDNAs(String[] DNAsFiles) {
		for (String DNAFile : DNAsFiles) {
			String DNA = Fetcher.fileToString(DNAFile);
			DNAs.add(DNA);
		}
	}
	
	public ArrayList<String> getDNAs() {
		return this.DNAs;
	}
	
}
