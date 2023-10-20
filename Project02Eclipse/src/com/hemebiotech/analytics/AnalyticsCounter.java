package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;

	// AnalyticsCounter constructor.
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}

	// Retrieves the list of symptoms from the data source.
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	// Counting and triaging symptoms.
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountTreeMap = new TreeMap<>();
		for (String symptom : symptoms) {
			symptomCountTreeMap.put(symptom, symptomCountTreeMap.getOrDefault(symptom, 0) + 1);
		}
		return symptomCountTreeMap;
	}

	// Saves the results to the output file.
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}
