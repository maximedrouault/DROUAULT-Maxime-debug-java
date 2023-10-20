package com.hemebiotech.analytics;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        // Instantiating ISymptomReader and ISymptomWriter objects
        ISymptomReader reader = new ReadSymptomDataFromFile(Path.of("./Project02Eclipse/symptoms.txt"));
        ISymptomWriter writer = new WriteSymptomDataToFile(Path.of("./Project02Eclipse/result.out"));


        // Instantiating AnalyticsCounter
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // Execution of the different stages of processing
        analyticsCounter.writeSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));
    }
}