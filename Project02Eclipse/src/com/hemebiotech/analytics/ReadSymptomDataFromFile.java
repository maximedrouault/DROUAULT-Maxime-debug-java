package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a simple brute force implementation of symptom data reading from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * The full or partial path to a file containing symptom strings, with one symptom per line.
	 */
	private final Path symptomsFilePath;

	/**
	 * Constructs a ReadSymptomDataFromFile object with the specified file path.
	 *
	 * @param symptomsFilePath The path to the file containing symptom strings.
	 */
	public ReadSymptomDataFromFile (Path symptomsFilePath) {
		this.symptomsFilePath = symptomsFilePath;
	}

	/**
	 * Retrieves a list of symptoms from the specified file.
	 *
	 * @return A list of symptom strings read from the file, one per line.
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> symptoms = new ArrayList<>();

		// Reading all lines from the specified file
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
