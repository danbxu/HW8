import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author danielxu and coreyparker
 *
 */

public class RC {

	static int digit = 0;
	/**
	 * killComma method iterates to through each char at each index and checks if it is a comma
	 * @param string
	 * @return
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
		//Return all 
		else {
			return string.charAt(0) + killCommas(string.substring(1));
		}
	}


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


	public void helper(int[] arr, List<Integer> current, List<List<Integer>> powerSet, int start) {

		//BC
		//This will add from current and create different permutation into ArrayList<Integer>
		powerSet.add(new ArrayList<Integer> (current));

		//Other cases
		for (int i = start; i < arr.length; i++) {
			current.add(arr[i]);
			helper(arr, current, powerSet, i + 1); //arr, current, and powerset stay the same, and i + 1 moves to the next
			current.remove(current.size() - 1);
		}

	}




	public void powerSet(int[] arr) {
		ArrayList<Integer> current = new ArrayList<>();
		List<List<Integer>> powerSet = new ArrayList<>();
		int start = 0;

		this.helper(arr, current, powerSet, start);

		for (int i = 0; i < powerSet.size(); i++) {
			System.out.println(powerSet.get(i));
		}

	}

	public static void main(String[] args) {
		//		System.out.println(killCommas("a,c"));
		//		System.out.println(killCommas(",abc,d"));
		//		System.out.println(killCommas(",___,"));
		//		System.out.println(killCommas("lma,o,"));
		//		System.out.println(killCommas(",,"));
		//		System.out.println(killCommas("a,c,d,,,"));
		//		System.out.println(killCommas(""));

		//		System.out.println(sumDigits(111)); // Need to ask about if i need to clear the variables
		//		System.out.println(sumDigits(123));


		RC a = new RC();
		int[] arr = {1,2,3};
		a.powerSet(arr);



	}
}




