package data.fetch.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Handler {
	
    // Private constructor to prevent instantiation
	private Handler() {
	    throw new UnsupportedOperationException();
	}
	
	protected static String[] readAllFiles(String folderName) {
		try {
	        String[] filesNames;
	        File f = new File(folderName);
	        filesNames = f.list();
		    return filesNames;
		} catch (Exception e) {
			System.err.println("Could not find any folder with this name");
			return null;
		}
	}
	
	protected static String fileToString(String fileName) {
		try {
	        Path path = Path.of(fileName);
	        return (Files.readString(path)).toUpperCase();
		} catch (IOException e) {
			System.err.println("error: could not find any file with this name -> " + fileName);
			return "";
		}
	}
}
