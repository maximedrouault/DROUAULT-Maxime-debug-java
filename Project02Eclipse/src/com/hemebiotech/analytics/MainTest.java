package com.hemebiotech.analytics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {
    public static void main(String[] args) {
        // LECTURE DES SYMPTÔMES
        // Chemin vers le fichier de symptômes (source).
        Path symptomsFilePath = Paths.get("./Project02Eclipse/symptoms.txt");

        // Instance de la classe ReadSymptomDataFromFile pour lecture du fichier.
        ReadSymptomDataFromFile symptomData = new ReadSymptomDataFromFile(symptomsFilePath);

        // Appel de la méthode GetSymptoms pour obtenir la liste des symptômes.
        List<String> symptoms = symptomData.getSymptoms();


        // COMPTAGE ET ENREGISTREMENT DES SYMPTÔMES
        // Traitement des symptômes pour compter leurs occurrences.
        Map<String, Integer> symptomCount = new TreeMap<>();
        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }

        // Chemin vers le fichier de résultat des symptômes comptabilisés (destination).
        Path resultFilePath = Paths.get("./Project02Eclipse/result.out");

        // Instance de la classe WriteSymptomDataToFile pour écrire les résultats dans le fichier "RESULT.OUT".
        WriteSymptomDataToFile results = new WriteSymptomDataToFile(resultFilePath);
        results.writeSymptoms(symptomCount);
    }
}
