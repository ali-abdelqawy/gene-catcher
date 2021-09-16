import algorithm.GeneFinder;
import errors.ErrorGenerator;
import validation.Validator;

public class Main {
    static String folderName = "";

    public static void main(String[] args) {
        try {
            folderName = args[0];
            GeneFinder.run(folderName);
        } catch (ArrayIndexOutOfBoundsException e) {
            ErrorGenerator.printError(ErrorGenerator.getEmptyFolderNameError());
        }
    }
}
