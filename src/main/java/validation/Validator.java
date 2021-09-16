package validation;

import constants.Codon;
import errors.ErrorGenerator;

public class Validator {

    public static boolean isStringEmpty(String s) {
        if (s == null)
            return true;

        return s.isEmpty() ? true : false;
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
