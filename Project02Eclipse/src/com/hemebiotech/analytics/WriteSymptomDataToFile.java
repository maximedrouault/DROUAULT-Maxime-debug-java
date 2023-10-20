package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	/**
	 * resultFilePath a full or partial path to file with regrouped and counted symptoms strings in it, one per line
	 */
	private final Path resultFilePath;

	public WriteSymptomDataToFile(Path resultFilePath) {
		this.resultFilePath = resultFilePath;
	}

	@Override
	public void writeSymptoms(Map<String,Integer> symptoms) {

		if (resultFilePath != null) {
			try {
				// Creation of the list of lines to write in the correct format.
				List<String> lines = new ArrayList<>();

				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					lines.add(entry.getKey() + " : " + entry.getValue());
				}
				// Saving in the "result.out" file.
				Files.write(resultFilePath, lines);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
