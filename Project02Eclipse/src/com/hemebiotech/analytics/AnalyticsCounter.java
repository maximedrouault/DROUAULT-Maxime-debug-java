package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class provides methods for counting and triaging symptoms, as well as saving the results to an output file.
 */
public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	/**
	 * Constructs an instance of AnalyticsCounter with the specified symptom reader and writer.
	 *
	 * @param reader The symptom reader to use for retrieving symptoms.
	 * @param writer The symptom writer to use for saving results.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}

	/**
	 * Retrieves the list of symptoms from the data source.
	 *
	 * @return A list of symptoms.
	 */
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	/**
	 * Counts and triages symptoms, returning a map of symptom counts.
	 *
	 * @param symptoms The list of symptoms to count and triage.
	 * @return A TreeMap containing symptom counts, where the keys are symptoms, and the values are the counts.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountTreeMap = new TreeMap<>();
		for (String symptom : symptoms) {
			symptomCountTreeMap.put(symptom, symptomCountTreeMap.getOrDefault(symptom, 0) + 1);
		}
		return symptomCountTreeMap;
	}

	/**
	 * Saves the results to the output file.
	 *
	 * @param symptoms The map of symptom counts to save to the output file.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}
