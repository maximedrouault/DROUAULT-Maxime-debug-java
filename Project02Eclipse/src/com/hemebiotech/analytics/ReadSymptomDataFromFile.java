package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
	 *  filepath a full or partial path to file with symptom strings in it, one per line
	 */
	private final Path symptomsFilePath;

	public ReadSymptomDataFromFile (Path symptomsFilePath) {
		this.symptomsFilePath = symptomsFilePath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> symptoms = new ArrayList<>();

		// Reading all lines of "SYMPTOMS.TXT"
		if (symptomsFilePath != null) {
			try {
				symptoms = Files.readAllLines(symptomsFilePath);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return symptoms;
	}
}
