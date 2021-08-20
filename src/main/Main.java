package main;

import java.util.ArrayList;
import java.util.HashMap;

import data.Holder;

public class Main {

	public static void main(String[] args) {
		Holder h = new Holder("DNAs");
		HashMap<String, String> DNAs = h.getDNAs();
		for (String dnaFile : DNAs.keySet()) {
			String strand = DNAs.get(dnaFile);
			System.out.println(dnaFile + ", " + strand);
		}
	}

}
