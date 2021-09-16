package input;

import java.util.ArrayList;

public class DNA {
    private final String fileName;
    private final String strand;
    private final ArrayList<String> genes = new ArrayList<>(0);

    public DNA(String fileName, String strand) {
        this.fileName = fileName;
        this.strand = strand;
    }

    public void addGene(String gene) {
        if(!gene.isEmpty())
            genes.add(gene);
    }

    public ArrayList<String> getGenes() {
        return genes;
    }

    public String getFileName() {
        return fileName;
    }

    public String getStrand() {
        return strand;
    }


}
