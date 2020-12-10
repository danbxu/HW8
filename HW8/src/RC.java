
public class RC {
	
 //problem 1
	
	//recursion charAt
	
	
	public String killCommas(String string) {
		
		
		if (string == null) throw new IllegalArgumentException ("No string");
		// recursive step
		
		killCommas(string.substring(1));
		
		
		return "lol";
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
		
	}
}




