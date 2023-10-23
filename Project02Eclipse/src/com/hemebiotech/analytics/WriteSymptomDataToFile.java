package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a simple brute force implementation of writing symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
	 * The full or partial path to a file where grouped and counted symptom strings are written, one per line.
	 */
	private final Path resultFilePath;

	/**
	 * Constructs a WriteSymptomDataToFile object with the specified file path.
	 *
	 * @param resultFilePath The path to the file where symptom data will be written.
	 */
	public WriteSymptomDataToFile(Path resultFilePath) {
		this.resultFilePath = resultFilePath;
	}

	/**
	 * Writes the symptom data, grouped and counted, to the specified file.
	 *
	 * @param symptoms A map containing symptom strings as keys and their corresponding counts as values.
	 */
	@Override
	public void writeSymptoms(Map<String,Integer> symptoms) {

		if (resultFilePath != null) {
			try {
				// Creating a list of lines to write in the correct format.
				List<String> lines = new ArrayList<>();

				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					lines.add(entry.getKey() + " : " + entry.getValue());
				}
				// Saving to the specified file.
				Files.write(resultFilePath, lines);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
