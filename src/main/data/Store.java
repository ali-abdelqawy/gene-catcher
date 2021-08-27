package main.data;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
	private String folderName = "";
	private ArrayList<DNA> DNAs = null;
	private HashMap<String, String> strandsByFiles = null;
	
	public Store(String folderName) {
		this.folderName = folderName;
		setStrandsByFiles();
		setDNAs();
	}
	
	public void setStrandsByFiles() {
		Fetcher fetcher = new Fetcher(folderName);
		this.strandsByFiles = fetcher.getFilesContent();
	}
	
	public void setDNAs() {
		ArrayList<DNA> DNAs = new ArrayList<DNA>(strandsByFiles.size());
		
	    for (HashMap.Entry<String, String> entry : strandsByFiles.entrySet()) {
	    	String fileName = entry.getKey(), strand = entry.getValue();
	        DNA dna = new DNA(fileName, strand);
	        DNAs.add(dna);
	    }
	    
	    this.DNAs = DNAs;
	}
	
	public ArrayList<DNA> getDNAs() {
	    return DNAs;
	}	
}
