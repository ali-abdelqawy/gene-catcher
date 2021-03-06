package validation;

import constants.Codon;
import errors.ErrorGenerator;

public class Validator {
    // Private constructor to prevent instantiation
    private Validator() {
        throw new UnsupportedOperationException();
    }

    public static boolean isStringEmpty(String s) {
        if (s == null)
            return true;

        return s.isEmpty();
    }

    public static boolean isFolderNameValid(String folderName) {
        folderName = folderName.trim();
        if (isStringEmpty(folderName)) {
            ErrorGenerator.printError(ErrorGenerator.getEmptyFolderNameError());
            return false;
        }
        return true;
    }

    public static boolean isGeneValid(int geneStart, int stopCodonIndex) {
        int distance = stopCodonIndex - geneStart;
        return distance % Codon.LENGTH == 0;
    }

}
