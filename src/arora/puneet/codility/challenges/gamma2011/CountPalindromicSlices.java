package arora.puneet.codility.challenges.gamma2011;


/*
 * 
	Challenge Description
	Challenge Source : https://app.codility.com/programmers/task/count_palindromic_slices/
 * 
 * 
 * 

In this problem we consider only strings consisting of lower-case English letters (a−z).

A string is a palindrome if it reads exactly the same from left to right as it does from right to left. For example, these strings are palindromes:

        aza
        abba
        abacaba

These strings are not palindromes:

        zaza
        abcd
        abacada

Given a string S of length N, a slice of S is a substring of S specified by a pair of integers (p, q), such that 0 ≤ p < q < N. A slice (p, q) of string S is palindromic if the string consisting of letters S[p], S[p+1], ..., S[q] is a palindrome. For example, in a string S = abbacada:

        slice (0, 3) is palindromic because abba is a palindrome,
        slice (6, 7) is not palindromic because da is not a palindrome,
        slice (2, 5) is not palindromic because baca is not a palindrome,
        slice (1, 2) is palindromic because bb is a palindrome.

Write a function

    class Solution { public int solution(String S); }

that, given a string S of length N letters, returns the number of palindromic slices of S. The function should return −1 if this number is greater than 100,000,000.

For example, for string S = baababa the function should return 6, because exactly six of its slices are palindromic; namely: (0, 3), (1, 2), (2, 4), (2, 6), (3, 5), (4, 6).

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..20,000];
        string S consists only of lowercase letters (a−z).


 *
 */

public class CountPalindromicSlices {
	
	public static void test_solution() {
		String S = "baababa";
		//String S = "abcde";
		
		int output = solution(S);
		
		System.out.println(output);
	}
	
	public static int solution(String S) {
		
		int palindromeCount =0;
		
		for (int i = 0; i < S.length(); i++) {
			String sub = S.substring(i);
			for (int j =1; j < sub.length(); j++) {
				if(isPalindrom(sub.substring(0,j+1).toCharArray())) {
					palindromeCount++;
				}
				if(palindromeCount>100000000) {
					return -1;
				}
			}
		}
		
		return palindromeCount;
	}
	
	public static boolean isPalindrom(char[] word){
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}

}
