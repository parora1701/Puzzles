package arora.puneet.codility.challenges.alpha2010;

import java.util.HashSet;
import java.util.Set;

/*
 * 
	Challenge Description
	Challenge Source : https://app.codility.com/programmers/task/prefix_set/
 * 
 * 

A non-empty array A consisting of N integers is given. The first covering prefix of array A is the smallest integer P such that 0≤P<N and such that every value that occurs in array A also occurs in sequence A[0], A[1], ..., A[P].

For example, the first covering prefix of the following 5−element array A:
  A[0] = 2
  A[1] = 2
  A[2] = 1
  A[3] = 0
  A[4] = 1

is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.

Write a function

    class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the first covering prefix of A.

For example, given array A such that
  A[0] = 2
  A[1] = 2
  A[2] = 1
  A[3] = 0
  A[4] = 1

the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..1,000,000];
        each element of array A is an integer within the range [0..N−1].


 * 
 */

public class PrefixSet {
	
	public static void test_solution() {
		int[] A = {2,2,1,1,1,5};
		int output = solution(A);
		System.out.println(output);
	}
	
	public static int solution(int[] A) {
		
		Set<Integer> aSet = new HashSet<Integer>();
		int desiredIndex = 0;
		
		for (int i = 0; i < A.length; i++) {
			if(aSet.add(A[i])) {
				desiredIndex=i;
			}
		}
		
		return desiredIndex;
	}

}
