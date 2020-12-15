import java.util.Arrays;

public class RC {

 static int digit = 0;

	public static String killCommas(String string) {
		if (string == null) return "";
			//throw new IllegalArgumentException ("No string");
		if (string.length() == 1) {
			if (string.charAt(0) == ',') {
				return ""; //this return needs to be fixed
			}
			else {
				return string; //this return needs to be fixed
			}
		}
		if (string.charAt(0) == ',') {
			return killCommas(string.substring(1));
		}
		else {
			return string.charAt(0) + killCommas(string.substring(1));
		}
	}
	
	
//perhaps create a helper function	

	public static int sumDigits(int num) {
		int hold;
	
			//throw new IllegalArgumentException ("num is negative");
		if (num == 0) {
			return digit;
		}
		if (num < 0) return -1;
		else {
			hold = num;
			digit = digit + num % 10;
			return sumDigits(hold / 10);
		}
	}
	
	public void powerSet(int[] arr) {
		
		if (arr.length == 0) {
			System.out.println("[]");
		}
		if (arr.length == 1) {
			System.out.println("{" + arr + "}");
		}
		if (arr.length > 1) {
			
		}
		
	}

	public static void main(String[] args) {
//		System.out.println(killCommas("a,c"));
//		System.out.println(killCommas(",abc,d"));
//		System.out.println(killCommas(",___,"));
//		System.out.println(killCommas("lma,o,"));
//		System.out.println(killCommas(",,"));
//		System.out.println(killCommas("a,c,d,,,"));
		
		System.out.println(sumDigits(111111)); // Need to ask about if i need to clear the variables
//		int[] arr = new int[] {1};
//
//		
//		System.out.println(Arrays.toString(arr));
		
	

	}
}




