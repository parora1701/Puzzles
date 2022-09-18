/**
 * 
 */
package arora.puneet.codility.lessons.l7_stacksAndQueues;

import java.util.ArrayList;

/**
 * @author Puneet Arora
 *
 */
/*
 * Puzzle Description
 * Puzzle Source : https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * 
 * 

A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

        S is empty;
        S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

    class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..200,000];
        string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".




 * 
 * 
 */
public class Brackets {
	
	static ArrayList<String> bracketStack = new ArrayList<String>();
	
	public static void push(ArrayList<String> stringList, String s) {
		stringList.add(s);
	}
	
	public static String pop(ArrayList<String> stringList) {
		return (stringList.isEmpty()?"":stringList.remove(stringList.size()-1));
	}
	
	public static void test_solution() {
		int N = 15;
		//1041 = 10000010001
		//32 = 100000
		//int[] A = {−1, −3};
		
		String S = "()";
		int output = solution(S);
		
		System.out.println(output);
	}
	
	public static int solution(String s) {
		int output = -1;
		boolean isNestedString = true;
		if(!s.isEmpty()) {
			int index = 0;
			int size = s.length();
			boolean continueWhile = true;
			do {
				//char currentChar = charArray[index];
				String currentChar = Character.toString(s.charAt(index));
				
				switch (currentChar) {
				case ")":
					if (!pop(bracketStack).equalsIgnoreCase("(")) {
						continueWhile = false;
						isNestedString = false;
					}
					break;
				case "}":
					if (!pop(bracketStack).equalsIgnoreCase("{")) {
						continueWhile = false;
						isNestedString = false;
					}
					break;
				case "]":
					if (!pop(bracketStack).equalsIgnoreCase("[")) {
						continueWhile = false;
						isNestedString = false;
					}
	
					break;

				default:
					push(bracketStack,currentChar);
					break;
				}
				
				index++;
			} while (index<size&&continueWhile);
			
		} 
		
		if(isNestedString&&bracketStack.isEmpty()) {
			output = 1;
		}else {
			output = 0;
		}
		
		return output;
		
		
	}

}
