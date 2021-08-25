package main;

import java.util.HashMap;

import main.data.DNA;

public class Main {

	public static void main(String[] args) {
		final String folderName = "input";
		HashMap<String, String> strandsByFiles = DNA.getStrandsByFiles(folderName);
	    for (HashMap.Entry<String, String> entry : strandsByFiles.entrySet()) {
	        System.out.println(entry.getKey());
	        System.out.println(entry.getValue());
	        System.out.println("-----------------------------------------------------------------------------");
	    }
	}

}
