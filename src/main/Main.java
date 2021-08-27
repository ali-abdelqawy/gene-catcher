package main;

import java.util.ArrayList;
import java.util.HashMap;

import main.data.DNA;

public class Main {

	public static void main(String[] args) {
		final String folderName = "input";
		
		HashMap<String, String> strandsByFiles = DNA.getStrandsByFiles(folderName.trim());
		if (strandsByFiles == null)
			return;
		
	}
}
