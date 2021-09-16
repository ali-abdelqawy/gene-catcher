package output;

import input.DNA;

public class Printer {

    public static void print(DNA dna) {
        System.out.println("filename -> " + "\"" + dna.getFileName() + "\"");
        System.out.println("");
        System.out.println("total genes = " + dna.getGenes().size());
        System.out.println("----------------------------------");
    }

}
