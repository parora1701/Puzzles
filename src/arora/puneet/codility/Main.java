package arora.puneet.codility;

import arora.puneet.codility.common.Utility;
import arora.puneet.codility.lessons.l1_iterations.BinaryGap;
import arora.puneet.codility.lessons.l2_arrays.CyclicRotation;
import arora.puneet.codility.lessons.l2_arrays.OddOccurrencesInArray;
import arora.puneet.codility.lessons.l5_prefixSums.PassingCars;
import arora.puneet.codility.lessons.l7_stacksAndQueues.Brackets;
import arora.puneet.codility.lessons.l7_stacksAndQueues.Fish;

public class Main {

	public static void main(String[] args) {
		

		// 
		//------------Test Lesson 7 Nesting Puzzle-------------
		//Nesting.test_solution();
		
		//------------Test Lesson 7 Fish Puzzle-------------
		//Fish.test_solution();
		
		//------------Test Lesson 7 Brackets Puzzle-------------
		//Brackets.test_solution();
		
		//------------Test Lesson 2 Cyclic Rotation Puzzle-------------
		//CyclicRotation.test_solution();
		
		//------------Test Lesson 1 Binary Gap Puzzle-------------
		//BinaryGap.test_solution();
		//test_solution("binarygap");
		//test_solution("passingcars");
		Long startTime=System.currentTimeMillis();
		OddOccurrencesInArray.test_solution();
		Long endTime=System.currentTimeMillis();
		Long duration = endTime-startTime;
		System.out.println("code run duration: "+ duration);
	}
	
	private static void test_solution(String input) {
		
		String key = input.toLowerCase();
		
		switch (key) {
		case "binarygap": {
			BinaryGap.test_solution();
			break;
		}
		case "cyclicrotation": {
			CyclicRotation.test_solution();
			break;
		}
		case "brackets": {
			Brackets.test_solution();
			break;
			//yield type;
		}
		case "fish": {
			Fish.test_solution();
			break;
			//yield type;
		}
		case "passingCars": {
			PassingCars.test_solution();
			break;
			//yield type;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
			
		}
	}

}
