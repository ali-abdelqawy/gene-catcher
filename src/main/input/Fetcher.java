package main.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import main.errors.ErrorGenerator;

public final class Fetcher {
	
	private String folderName;
	
	protected Fetcher(String folderName) {			
		this.folderName = folderName;
	}
	
	public HashMap<String, String> getFilesContent() {
		String[] fileNames = getFilesNames();
		if (fileNames == null)
			return null;
		ArrayList<String> filesContent =  getFilesContent(fileNames);
	    HashMap<String, String> contentByFiles = new HashMap<>();

		for (int i = 0; i < fileNames.length; i++) {
			contentByFiles.put(fileNames[i], filesContent.get(i));
		}
		
		return contentByFiles;
	}
	
	private String[] getFilesNames() {
	        String[] filesNames;
	        File f = new File(folderName);
	        filesNames = f.list();
	        if (filesNames == null)
	        	ErrorGenerator.printError(ErrorGenerator.getNoFolderFoundError(folderName));
		    return filesNames;
	}
	
	private ArrayList<String> getFilesContent(String[] fileNames) {
		ArrayList<String> filesContent = new ArrayList<String>(0);
		
		for (String fileName : fileNames) {
			String fileContent = fileToString(folderName + "/" + fileName);
			if (!fileName.isEmpty())
				filesContent.add(fileContent);
		}
		
		return filesContent;
	}
	
	private String fileToString(String fileName) {
		try {
	        Path path = Path.of(fileName);
	        String fileContent = Files.readString(path).toUpperCase();
	        return fileContent;
		} catch (IOException e) {
			ErrorGenerator.printError(ErrorGenerator.getNoFileFoundError(fileName));
			return "";
		}
	}
	
}
