package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class OldAnalyticsCounter {
	private static int headAcheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader(".\\Project02Eclipse\\symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headAcheCount++;
				System.out.println("number of headaches: " + headAcheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		reader.close();

		FileWriter writer = new FileWriter (".\\Project02Eclipse\\result.out");
		writer.write("headache: " + headAcheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
