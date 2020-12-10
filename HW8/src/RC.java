
public class RC {

	//problem 1

	//recursion charAt


	public static String killCommas(String string) {


		if (string == null) throw new IllegalArgumentException ("No string");
		// recursive step
		
		if (string.charAt(0) == ',') {
			return killCommas(string.substring(1));
		}
		else {
			return string.charAt(0) + killCommas(string.substring(1));
		}

	}

	//problem 2

	public static int sumDigits(int num) {
		//		int sum = 0;

		//base case
		if (num < 0) throw new IllegalArgumentException ("num is negative");
		if (num == 0) return num;

		int digit = num % 10; //give us the second digit on the left




		return 3;

	}





	public static void main(String[] args) {
		killCommas("a,");

	}
}




