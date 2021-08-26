package main.errors;

public class ErrorGenerator {
	public static String getEmptyFolderNameError() {
		return "You must specify the folder name";
	}
	
	public static String getNoFolderFoundError(String folderName) {
		return "error: could not find any folder with this name -> " + folderName;
	}
	
	public static String getNoFileFoundError(String fileName) {
		return "error: could not find any file with this name -> " + fileName;
	}
	
	public static void printError(String error) {
		System.err.println(error);
	}
}
