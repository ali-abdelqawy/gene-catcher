package output;

import input.DNA;

public final class Printer {
    // Private constructor to prevent instantiation
    private Printer() {
        throw new UnsupportedOperationException();
    }

    public static void print(DNA dna) {
        System.out.println("filename -> " + "\"" + dna.getFileName() + "\"" + "\n");
        System.out.println("total genes = " + dna.getGenes().size());
        System.out.println("----------------------------------------------------------");
    }

}
