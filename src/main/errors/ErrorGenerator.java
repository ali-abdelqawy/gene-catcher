package main.errors;

public class ErrorGenerator {
	public static String getEmptyFolderNameError() {
		return "you must specify the folder name";
	}
	
	public static String getNoFolderFoundError(String folderName) {
		return "could not find any folder with this name -> " + "\"" + folderName + "\"";
	}
	
	public static String getNoFileFoundError(String fileName) {
		return "could not find any file with this name -> " + fileName;
	}
	
	public static void printError(String error) {
		System.err.println("error: " + error);
	}
}
