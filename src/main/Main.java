package main;

import java.util.ArrayList;
import java.util.HashMap;

import main.data.DNA;

public class Main {

	public static void main(String[] args) {
		final String folderName = "input";
		
		HashMap<String, String> strandsByFiles = DNA.getStrandsByFiles(folderName.trim());
		if (strandsByFiles == null)
			return;
		
	}
	
	public static ArrayList<DNA> getDNAs(HashMap<String, String> strandsByFiles) {
		ArrayList<DNA> DNAs = new ArrayList<DNA>(strandsByFiles.size());
		
	    for (HashMap.Entry<String, String> entry : strandsByFiles.entrySet()) {
	    	String fileName = entry.getKey(), strand = entry.getValue();
	        DNA dna = new DNA(fileName, strand);
	        DNAs.add(dna);
	    }
	    
	    return DNAs;
	}

}
