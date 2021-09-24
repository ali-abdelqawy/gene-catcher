package constants;

public final class Codon {
    public final static String START = "ATG";
    public enum Stop {
        TAA, TAG, TGA
    };
    public final static int LENGTH = 3;

    // Private constructor to prevent instantiation
    private Codon() {
        throw new UnsupportedOperationException();
    }

}
