package arora.puneet.codility.lessons.l3_prefixSums;

import java.util.Arrays;

import arora.puneet.codility.common.Utility;

/**
 * @author Puneet Arora
 *
 */
/*
 * Puzzle Description
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * 
 * 
 
 A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
 
 */


public class PassingCars {
	
	public static void test_solution() {
		//int N = 15;
		//1041 = 10000010001
		//32 = 100000
		//int[] A = {0,1,0,1,1};
		int[] A = Utility.randomIntArrayGenerator(100000, 0, 1);
		//System.out.println(Utility.stringifyIntArray(A));
		
		
		int output = solution(A);
		
		System.out.println(output);
	}
	
	//Below is O(n) solution, we will look at the item in the array exactly once and gather enough information to utilize it later.
	public static int solution(int[] A) {
		int totalPassingCarsCount = 0;
		int totalZerosCount = 0;
		boolean continueLoop=true;
		
		for (int i = 0; i < A.length&&continueLoop; i++) {
			if(A[i]==0) {
				totalZerosCount+=1;
			} else {
				totalPassingCarsCount+=totalZerosCount;
			}
			if(totalPassingCarsCount>1000000000) {
				totalPassingCarsCount=-1;
				continueLoop=false;
			}
			
		}
		return totalPassingCarsCount;
	}
		
	
	
	//Below are two O(n2) solutions
	public static int solution2(int[] A) {
		int totalPassingCarsCount = 0;
		boolean continueLoop=true;
		for (int i = 0; i < A.length; i++) {
			if(A[i]==0) {
				for (int j = i+1; j < A.length&&continueLoop; j++) {
					if(A[j]==1) {
						totalPassingCarsCount+=1;
						if(totalPassingCarsCount>1000000000) {
							totalPassingCarsCount=-1;
							continueLoop=false;
						}
					}
				}
			}
			
		}
		
			
		return totalPassingCarsCount;
	}
	
public static int solution1(int[] A) {
		
		String aString=Arrays.toString(A).replace(", ","");
		String originalArray=aString.substring(1, A.length+1);
		String currentArray =  originalArray;
		int totalPassingCarsCount = 0;
		boolean continueWhile=true;
		
		do {
			int indexOf0=currentArray.indexOf('0');
			
			if(indexOf0==-1) {
				continueWhile=false;
			} else {
				currentArray = currentArray.substring(indexOf0+1);
				String arrayToWorkOn = currentArray;
				int currentPassingCarsCount = currentArray.length() - arrayToWorkOn.replace("1", "").length();
				//System.out.println("currentPassingCarsCount = " + currentPassingCarsCount);
				totalPassingCarsCount=totalPassingCarsCount+currentPassingCarsCount;
				
			}
			
			if(totalPassingCarsCount>1000000000) {
				totalPassingCarsCount=-1;
				continueWhile=false;
			}
			
			
		} while (continueWhile);
		
		
		return totalPassingCarsCount;
	}
}
