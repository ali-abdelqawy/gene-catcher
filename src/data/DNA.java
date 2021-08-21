package data;

public class DNA {
	private String strand = "";
	private String fileName = "";
	final static String startCodon = "ATG";
	final static String[] stopCodons = {"TAA", "TAG", "TGA"};
	final static int codonLength = 3;
}
