import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author danielxu and coreyparker
 *
 */


public class RecursiveQuestion {

	static int digit = 0;
	/**
	 * killComma method iterates to through each char at each index and checks if it is a comma.
	 * This method checks for two base cases and for other cases, the method is called recursively to remove all commas if it exists
	 * or moves to the next index of the string if comma does not exist. 
	 * @param string
	 * @return print string
	 */
	public static String killCommas(String string) {
		//Base case: no string
		if (string == "") throw new IllegalArgumentException ("No string");
		//Base case: string length = 1
		if (string.length() == 1) {
			if (string.charAt(0) == ',') {
				return ""; 
			}
			else {
				return string;  
			}
		}
		//If charAt(0) is a comma, remove the comma and return 1 index after
		if (string.charAt(0) == ',') {
			return killCommas(string.substring(1));
		}
		//Return all since no comma
		else {
			return string.charAt(0) + killCommas(string.substring(1));
		}
	}

	/**
	 * This method iterates through int num and checks for base cases when num = 0 and when num is negative.
	 * If greater than 0, then the method is called recursively to add the digits together to sum digits variable.
	 * @param num
	 * @return
	 */

	public static int sumDigits(int num) {
		//Base case: number is zero
		if (num == 0) {
			int output = digit;
			digit = 0;
			return output;
		}
		//Base case: number given is negative
		if (num < 0) throw new IllegalArgumentException ("No negative numbers");
		else {
			//Modulo to num and add to digit (running total)
			digit = digit + num % 10;
			return sumDigits(num / 10);
		}
	}

	/*
	 * This method iterates through the int[] arr and repeatedly adds a new element into powerSet to create a different permutation
	 * from taking an element from the ArrayList<Integer> current. To perform this process and finding powerSet, this method uses 
	 * helper() function which uses a for loop to repeatedly get a subset of the powerSet. Finally, this method uses a forloop to
	 * iterate through each element in the powerSet to print the element on a new line. 
	 * 
	 * @param arr
	 */
	public void powerSet(int[] arr) {
		ArrayList<Integer> current = new ArrayList<>();
		List<List<Integer>> powerSet = new ArrayList<>();
		int start = 0;

		this.helper(arr, current, powerSet, start);

		for (int i = 0; i < powerSet.size(); i++) {
			System.out.println(powerSet.get(i));
		}

	}

	/*
	 * Helper function for powerSet. This takes in arr, current, powerSet, and start, which are all initialized within 
	 * powerSet() method. This method recursively returns each unique subset of powerSet. 
	 * 
	 * @param arr
	 * @param current
	 * @param powerSet
	 * @param start
	 */
	public void helper(int[] arr, List<Integer> current, List<List<Integer>> powerSet, int start) {
		//This will add from current into powerSet
		powerSet.add(new ArrayList<Integer> (current));

		//All cases, includes the bases case of int[]arr with (1) no elements and (2) 1 element
		for (int i = start; i < arr.length; i++) {
			current.add(arr[i]);  //adds 1 element from arr to current
			helper(arr, current, powerSet, i + 1); // arguments arr, current, and powerset stay the same, and i + 1 moves to the next set of powerSet
			current.remove(current.size() - 1); //this removes what's in the current 
		}

	}

	public static void main(String[] args) {

				//Test cases 
//				System.out.println(killCommas("a,c"));
//				System.out.println(killCommas(",abc,d"));
//				System.out.println(killCommas(",___,"));
//				System.out.println(killCommas(",_,_,"));
//				System.out.println(killCommas(",,,"));
//				System.out.println(killCommas("lma,o,"));
//				System.out.println(killCommas(",,"));
//				System.out.println(killCommas("a,c,d,,,"));
////				System.out.println(killCommas("")); //For testing empty
//				System.out.println(sumDigits(111)); 
//				System.out.println(sumDigits(123));
//				System.out.println(sumDigits(456));
//				
//				RecursiveQuestion a = new RecursiveQuestion();
//				int[] arr = {1,2,3};
//				a.powerSet(arr);

	}
}




