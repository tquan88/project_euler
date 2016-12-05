package sandbox;

public class Euler36 {

	private static boolean isPalindromicB10 (int n) {
		return Integer.toString(n).equals(new StringBuilder(Integer.toString(n)).reverse().toString());
	}
	
	private static boolean isPalindromicB2 (int n) {
		return Integer.toBinaryString(n).equals(new StringBuilder(Integer.toBinaryString(n)).reverse().toString());
	}
	
	public static void getAnswer() {
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isPalindromicB10(i) && isPalindromicB2(i)) sum += i;
		}
		
		System.out.println(sum);
		
	}
	
	
}
