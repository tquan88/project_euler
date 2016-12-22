package sandbox;

import java.util.LinkedHashSet;
import java.util.Set;

public class Euler37 {

	
	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
	}
	
	public static void getAnswer() {
		
		Set<Integer> primeNumbers = new LinkedHashSet<Integer>();
		
		for (int n = 2; n < 1000001; n++) {
			if (isPrime(n)) primeNumbers.add(n);
		}
		
		int answer = 0;
		
		for (int i = 11; i < 1000001; i++) {
			if (!primeNumbers.contains(i)) continue;
			
			int number = i;
			boolean isStillPrime = true;
			
			// right to left
			while (number > 10) {
				number = number / 10;
				if (!primeNumbers.contains(number)) {
					isStillPrime = false;
					break;
				}
			}
			
			number = (isStillPrime) ? i : 0;
			
			int numberLength = String.valueOf(number).length();
			// left to right
			while (numberLength > 1) {
				number = number % (int) Math.pow(10, numberLength-1);
				if (!primeNumbers.contains(number)) {
					isStillPrime = false;
					break;
				}
				numberLength--;
			}
			
			if (isStillPrime) answer += i;
		
		}
		
		System.out.println(answer);
		
	}
	
}
