package input;

import java.util.ArrayList;

public class DNA {
    private String fileName = "";
    private String strand = "";
    private ArrayList<String> genes = new ArrayList<String>(0);

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
