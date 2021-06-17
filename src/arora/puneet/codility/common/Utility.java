package arora.puneet.codility.common;

public class Utility {
	
	public static String stringifyIntArray(int[] A) {
		String output = "[";
		
		for (int i : A) {
			output = output + i + ", ";
		}
		
		output = output + "]";
		
		return output;
	}
}
