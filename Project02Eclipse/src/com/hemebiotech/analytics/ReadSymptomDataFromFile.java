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
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	private Path symptomsFilePath;

	public ReadSymptomDataFromFile (Path symptomsFilePath) {
		this.symptomsFilePath = symptomsFilePath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> symptoms = new ArrayList<>();

		// Lecture de toutes les lignes de "SYMPTOMS.TXT"
		if (symptomsFilePath != null) {
			try {
				symptoms = Files.readAllLines(symptomsFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return symptoms;
	}
}
