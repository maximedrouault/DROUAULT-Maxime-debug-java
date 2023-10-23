package com.hemebiotech.analytics;

import java.util.Map;

/**
 * This interface represents anything that can write symptom data to a destination.
 * The critical aspect of this operation is the return value, which is a Map of strings and integers.
 */
public interface ISymptomWriter {

	/**
	 * Writes symptom data to a destination.
	 *
	 * @param symptoms A Map of symptoms and their corresponding counts to be written.
	 */
	void writeSymptoms(Map<String, Integer> symptoms);
}