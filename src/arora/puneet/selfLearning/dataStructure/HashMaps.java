/**
 * 
 */
package arora.puneet.selfLearning.dataStructure;

import java.util.HashMap;

/**
 * 
 */
public class HashMaps {

	public static void wordCounter(String sentence) {
		String[] allWords = sentence.split(" ");
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		
		for (String word : allWords) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
		}
		System.out.println(wordCountMap);
	}
}
