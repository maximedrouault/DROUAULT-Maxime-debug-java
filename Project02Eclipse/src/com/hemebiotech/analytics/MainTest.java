package com.hemebiotech.analytics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {
    public static void main(String[] args) {
        // READING THE SYMPTOMS
        // Path to the symptoms file (source).
        Path symptomsFilePath = Paths.get("./Project02Eclipse/symptoms.txt");

        // Instance of the ReadSymptomDataFromFile class for reading the file.
        ReadSymptomDataFromFile symptomData = new ReadSymptomDataFromFile(symptomsFilePath);

        // Calling the GetSymptoms method to get the list of symptoms.
        List<String> symptoms = symptomData.getSymptoms();


        // COUNTING AND RECORDING SYMPTOMS
        // Treatment of symptoms to count their occurrences.
        Map<String, Integer> symptomCount = new TreeMap<>();
        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }

        // Path to the counted symptoms result file (destination).
        Path resultFilePath = Paths.get("./Project02Eclipse/result.out");

        // Instance of the WriteSymptomDataToFile class to write the results to the "RESULT.OUT" file.
        WriteSymptomDataToFile results = new WriteSymptomDataToFile(resultFilePath);
        results.writeSymptoms(symptomCount);
    }
}
