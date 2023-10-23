package com.hemebiotech.analytics;

import java.util.List;

/**
 * This interface represents anything that can read symptom data from a data source.
 * The crucial aspect of this operation is the return value, which is a list of strings.
 * The list may contain duplicate entries, and the implementation is not required to sort the list.
 */
public interface ISymptomReader {

	/**
	 * Retrieves a list of symptoms from a data source.
	 *
	 * @return A raw listing of all symptoms obtained from a data source. Duplicates are possible and even probable.
	 *         If no data is available, the method should return an empty List.
	 */
	List<String> getSymptoms();
}