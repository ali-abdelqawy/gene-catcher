package main.algorithm;

import java.util.ArrayList;

import main.input.DNA;
import main.input.Store;
import main.validation.Validator;
import main.output.Printer;

public class GeneFinder {

	private DNA dna = null;
	private String strand = "";
	
	public GeneFinder(DNA dna) {
		this.dna = dna;
		this.strand = dna.getStrand();
	}

	public static void run(String folderName) {
		if (!Validator.isFolderNameValid(folderName))
			return;
		
		Store store = new Store(folderName);
			
		ArrayList<DNA> DNAs = store.getDNAs();
		for (DNA dna : DNAs) {
			GeneFinder gf = new GeneFinder(dna);
			gf.findAllGenes();
			Printer.print(gf.dna);
		}
	}
	
	private void findAllGenes() {
		if (strand.isEmpty())
			return;
		
		int fromIndex = 0, startCodonIndex = getStartCodonIndex(fromIndex);
		
		while (startCodonIndex != -1) {
			String gene = findGene(startCodonIndex);
			dna.addGene(gene);
			// Update the start index to look for the next gene
			fromIndex = startCodonIndex;
			fromIndex += gene.isEmpty() ? DNA.codonLength : gene.length();
			
			startCodonIndex = getStartCodonIndex(fromIndex);
		}
	}

	private int getStartCodonIndex(int fromIndex) {
		return strand.indexOf(DNA.startCodon, fromIndex);
	}
	
	private String findGene(int geneStart) {
		int minIndex = getMinIndex(geneStart);
		return minIndex != -1 ? strand.substring(geneStart, minIndex + DNA.codonLength) : "";
	}
	
	private int getMinIndex(int geneStart) {
		int minIndex = -1,
			taaIndex = getStopCodonIndex(DNA.stopCodons.TAA.toString(), geneStart, geneStart),
			tagIndex = getStopCodonIndex(DNA.stopCodons.TAG.toString(), geneStart, geneStart),
			tgaIndex = getStopCodonIndex(DNA.stopCodons.TGA.toString(), geneStart, geneStart);
		
		minIndex = getMinIndexBetweenTwo(taaIndex, tagIndex);
		minIndex = getMinIndexBetweenTwo(minIndex, tgaIndex);
		
		return minIndex;
			
	}
	
	private int getStopCodonIndex(String stopCodon, int geneStart, int fromIndex) {
		int stopCodonIndex = strand.indexOf(stopCodon, fromIndex);
		if (stopCodonIndex != -1)
			return Validator.isGeneValid(geneStart, stopCodonIndex) ?
				   stopCodonIndex :
				   getStopCodonIndex(stopCodon, geneStart, stopCodonIndex + DNA.codonLength);
		return -1;
	}
	
	private static int getMinIndexBetweenTwo(int firstIndex, int secondIndex) {
		return isSecondIndexSmaller(firstIndex, secondIndex) ? secondIndex : firstIndex;
	}
	
	private static boolean isSecondIndexSmaller(int firstIndex, int secondIndex) {
		return (firstIndex == -1 || (secondIndex != -1 && secondIndex < firstIndex));		
	}
	
}
