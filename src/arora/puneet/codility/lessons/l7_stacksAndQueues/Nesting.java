package arora.puneet.codility.lessons.l7_stacksAndQueues;

import java.util.ArrayList;

/**
 * @author PUNA
 *
 */
/*
 * Puzzle Description Puzzle Source :
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 * 
 * 
 * A string S consisting of N characters is called properly nested if:
 * 
 * S is empty; S has the form "(U)" where U is a properly nested string; S has
 * the form "VW" where V and W are properly nested strings.
 * 
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if string S is
 * properly nested and 0 otherwise.
 * 
 * For example, given S = "(()(())())", the function should return 1 and given S
 * = "())", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..1,000,000]; string S consists only of
 * the characters "(" and/or ")".
 * 
 * 
 * 
 */
public class Nesting {

	static ArrayList<String> bracketStack = new ArrayList<String>();

	public static void push(ArrayList<String> stringList, String s) {
		stringList.add(s);
	}

	public static String pop(ArrayList<String> stringList) {
		return (stringList.isEmpty() ? "" : stringList.remove(stringList.size() - 1));
	}

	public static void test_solution() {

		// 1041 = 10000010001
		// 32 = 100000
		// int[] A = {4,3,2,1,5};
		// int[] B = {0,1,0,0,0};
		String S = ")()";
		int output = solution(S);

		System.out.println(output);
	}

	public static int solution(String S) {
		int output = -1;
		boolean isNestedString = true;
		if(!S.isEmpty()) {
			int index = 0;
			int size = S.length();
			boolean continueWhile = true;
			do {
				//char currentChar = charArray[index];
				String currentChar = Character.toString(S.charAt(index));
				
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
