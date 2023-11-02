package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.nio.file.Path;

/**
 * The Main class is the entry point for the symptom data processing application.
 */
public class Main {

    public static void main(String[] args) {
        // Instantiating ISymptomReader and ISymptomWriter objects
        ISymptomReader reader = new ReadSymptomDataFromFile(Path.of("./Project02Eclipse/symptoms.txt"));
        ISymptomWriter writer = new WriteSymptomDataToFile(Path.of("./Project02Eclipse/result.out"));


        // Instantiating AnalyticsCounter
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // Get the symptoms from source file.
        List<String> symptoms = analyticsCounter.getSymptoms();
        // Count, group and sort symptoms.
        Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
        // Write the symptoms and their counts to result file.
        analyticsCounter.writeSymptoms(symptomCounts);
    }
}