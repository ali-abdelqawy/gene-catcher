package algorithm;

import java.util.ArrayList;

import constants.Codon;
import input.DNA;
import input.Store;
import validation.Validator;
import output.Printer;

public class GeneFinder {

    private DNA dna;
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
        if (DNAs == null)
            return;

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
            fromIndex += gene.isEmpty() ? Codon.LENGTH : gene.length();

            startCodonIndex = getStartCodonIndex(fromIndex);
        }
    }

    private int getStartCodonIndex(int fromIndex) {
        return strand.indexOf(Codon.START, fromIndex);
    }

    private String findGene(int geneStart) {
        int minIndex = getMinIndex(geneStart);
        return minIndex != -1 ? strand.substring(geneStart, minIndex + Codon.LENGTH) : "";
    }

    private int getMinIndex(int geneStart) {
        int minIndex = -1,
                taaIndex = getStopCodonIndex(Codon.Stop.TAA.toString(), geneStart, geneStart),
                tagIndex = getStopCodonIndex(Codon.Stop.TAG.toString(), geneStart, geneStart),
                tgaIndex = getStopCodonIndex(Codon.Stop.TGA.toString(), geneStart, geneStart);

        minIndex = getMinIndexBetweenTwo(taaIndex, tagIndex);
        minIndex = getMinIndexBetweenTwo(minIndex, tgaIndex);

        return minIndex;

    }

    private int getStopCodonIndex(String stopCodon, int geneStart, int fromIndex) {
        int stopCodonIndex = strand.indexOf(stopCodon, fromIndex);
        if (stopCodonIndex != -1)
            return Validator.isGeneValid(geneStart, stopCodonIndex) ?
                    stopCodonIndex :
                    getStopCodonIndex(stopCodon, geneStart, stopCodonIndex + Codon.LENGTH);
        return -1;
    }

    private static int getMinIndexBetweenTwo(int firstIndex, int secondIndex) {
        return isSecondIndexSmaller(firstIndex, secondIndex) ? secondIndex : firstIndex;
    }

    private static boolean isSecondIndexSmaller(int firstIndex, int secondIndex) {
        return (firstIndex == -1 || (secondIndex != -1 && secondIndex < firstIndex));
    }

}
