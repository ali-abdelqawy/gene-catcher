package main.algorithm;

import java.util.ArrayList;

import main.data.DNA;
import main.data.Store;
import main.validation.Validator;

public class GeneFinder {

	private ArrayList<DNA> DNAs = null;
	
	public GeneFinder(String folderName) {
		if (!Validator.isFolderNameValid(folderName))
			return;
		
		Store store = new Store(folderName);
		DNAs = store.getDNAs();		
	}

}
