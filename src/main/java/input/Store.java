package input;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private final String folderName;
    private ArrayList<DNA> DNAs;
    private HashMap<String, String> strandsByFiles;

    public Store(String folderName) {
        this.folderName = folderName;
        setStrandsByFiles();
        setDNAs();
    }

    public void setStrandsByFiles() {
        Fetcher fetcher = new Fetcher(folderName);
        if (fetcher.getFilesContent() == null)
            return;
        this.strandsByFiles = fetcher.getFilesContent();
    }

    public void setDNAs() {
        if (strandsByFiles == null)
            return;

        ArrayList<DNA> DNAs = new ArrayList<>(strandsByFiles.size());
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
