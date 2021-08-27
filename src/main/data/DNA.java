package main.data;

import java.util.ArrayList;
import java.util.HashMap;

import main.errors.ErrorGenerator;
import main.validation.Validator;

public class DNA {
	private final static String startCodon = "ATG";
	private final static String[] stopCodons = {"TAA", "TAG", "TGA"};
	private final static int codonLength = 3;
	private String fileName = "";
	private String strand = "";
	private ArrayList<String> genes = new ArrayList<String>(0);
	
	public DNA(String fileName, String strand) {
		this.fileName = fileName;
		this.strand = strand;
	}
	
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
	
	public static ArrayList<DNA> getDNAs(HashMap<String, String> strandsByFiles) {
		ArrayList<DNA> DNAs = new ArrayList<DNA>(strandsByFiles.size());
		
	    for (HashMap.Entry<String, String> entry : strandsByFiles.entrySet()) {
	    	String fileName = entry.getKey(), strand = entry.getValue();
	        DNA dna = new DNA(fileName, strand);
	        DNAs.add(dna);
	    }
	    
	    return DNAs;
	}	
	
	public void addGene(String gene) {
		if(!gene.isEmpty())
			genes.add(gene);
	}
}
