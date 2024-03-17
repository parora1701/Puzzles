package arora.puneet.codility.common;

import java.util.Arrays;
import java.util.Random;

public class Utility {
	
	public static String stringifyIntArray(int[] A) {
		/*
		 * String output = "[";
		 * 
		 * for (int i : A) { output = output + i + ", "; }
		 * 
		 * output = output + "]";
		 */
		
		return Arrays.toString(A);
	}
	
	public static int[] randomIntArrayGenerator(int arrayLength, int minValue, int maxValue) {
		int[] output = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			output[i]=new Random().nextInt(maxValue - minValue + 1) + minValue;
			
		}
		
		
		return output;
	}
}
