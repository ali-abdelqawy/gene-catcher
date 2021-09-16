import algorithm.GeneFinder;
import errors.ErrorGenerator;

public class Main {
    public static void main(String[] args) {
        try {
            String folderName = args[0];
            GeneFinder.run(folderName);
        } catch (ArrayIndexOutOfBoundsException e) {
            ErrorGenerator.printError(ErrorGenerator.getEmptyFolderNameError());
        }
    }
}
