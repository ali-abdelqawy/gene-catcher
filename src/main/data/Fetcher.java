package main.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public final class Fetcher {
	
	private String folderName;
	
	public Fetcher(String folderName) {
		this.folderName = folderName;
	}
	
	public HashMap<String, String> getFilesContent() {
		if (folderName.isEmpty() || folderName.isBlank()) {
			System.err.println("You must specify the folder name");
			return null;
		}

		String[] fileNames = getFilesNames();
		
		ArrayList<String> filesContent =  getFilesContent(fileNames);
		
	    HashMap<String, String> contentByFiles = new HashMap<>();

		for (int i = 0; i < fileNames.length; i++) {
			contentByFiles.put(fileNames[i], filesContent.get(i));
		}
		
		return contentByFiles;
	}
	
	private String[] getFilesNames() {
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
	
	private ArrayList<String> getFilesContent(String[] fileNames) {
		ArrayList<String> filesContent = new ArrayList<String>(0);
		
		for (String fileName : fileNames) {
			String fileContent = fileToString(folderName + "/" + fileName);
			filesContent.add(fileContent);
		}
		
		return filesContent;
	}
	
	private String fileToString(String fileName) {
		try {
	        Path path = Path.of(fileName);
	        return (Files.readString(path)).toUpperCase();
		} catch (IOException e) {
			System.err.println("error: could not find any file with this name -> " + fileName);
			return "";
		}
	}
}
