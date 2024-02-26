/**
 * 
 */
package arora.puneet.codility.lessons.l1_iterations;

/**
 * @author Puneet Arora
 *
 */
/*
 * Puzzle Description
 * Puzzle Source : https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * 
 * 

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded  
by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. 
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. 
The number 20 has binary representation 10100 and contains one binary gap of length 1. 
The number 15 has binary representation 1111 and has no binary gaps. 
The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

    class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap.
 The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and 
so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has 
binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..2,147,483,647].

 * 
 * 
 */

public class BinaryGap {
	
	public static void test_solution() {
		int N = 15598765;
		//1041 = 10000010001
		//32 = 100000
		//int[] A = {−1, −3};
		
		int output = solution(N);
		System.out.println("input : " +N);
		System.out.println("Binary representation of input is : " + Integer.toBinaryString(N));
		System.out.println("Binary Gap is : " + output);
	}
	
	public static int solution(int N) {
		int input = N;
		int output = 0;
		
		String binaryString = Integer.toBinaryString(input);
		boolean continueWhile = true;
		int binaryGap = 0;
		do {
			int currentBinaryGap = 0;
			int firstOne = -1;
			int secondOne = -1;
			
			firstOne = binaryString.indexOf('1');		
			
			if (firstOne != -1) {
				binaryString = binaryString.substring(firstOne+1);
				
				secondOne = binaryString.indexOf('1');
				
				if(secondOne !=-1) {
					firstOne = 0;
					currentBinaryGap = secondOne-firstOne;
					//System.out.println("currentBinaryGap = "+currentBinaryGap);
					if(currentBinaryGap>binaryGap) {
						binaryGap=currentBinaryGap;
					}
				}else {
					continueWhile = false;
				}
				
			} else {
				continueWhile = false;
			}
			
			
		} while (continueWhile);
		
		output=binaryGap;
		
		return output;
		
		
	}

}
