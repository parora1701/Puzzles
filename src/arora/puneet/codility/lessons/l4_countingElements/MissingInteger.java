package arora.puneet.codility.lessons.l4_countingElements;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Puzzle Description
 * Puzzle Source : https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * 
 * 

This is a demo task.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].


 * 
 * 
 */

public class MissingInteger {
	
	public static void test_solution() {
		int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {−1, −3};
		
		int output = solution(A);
		
		System.out.println(output);
	}
	
	 public static int solution(int[] A) {
		 
		 Set<Integer> aTree = new TreeSet<Integer>();
		 int minValue = 1;
		 for (int value : A) {
			 if(value>0) {
				 aTree.add(value);
			 }
		}
		 
		 for (Iterator iterator = aTree.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(integer>minValue) {
				return minValue;
			} else {
				minValue++;
			}
		}
		 
		 return minValue;
	 }

}
