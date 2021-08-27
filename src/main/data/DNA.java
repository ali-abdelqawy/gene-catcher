package main.data;

import java.util.ArrayList;

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
	
	public static String getStartCodon() {
		return startCodon;
	}
	
	public static String[] getStopCodons() {
		return stopCodons;
	}
	
	public void addGene(String gene) {
		if(!gene.isEmpty())
			genes.add(gene);
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String getStrand() {
		return this.strand;
	}
	
	public static int getCodonLength() {
		return codonLength;
	}
	
}
