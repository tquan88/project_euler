package sandbox;

import java.util.LinkedHashSet;
import java.util.Set;

public class Euler35 {

	int[] factorials = {
			1,
			1,
			2,
			6,
			24,
			120,
			720,
			5040,
			40320,
			362880,	
		};
	
	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}
	
	public void getAnswer () {
			
			//System.out.println(fact(9) + "");
			
			Set<Integer> primeNumbers = new LinkedHashSet<Integer>();
					
			for (int n = 2; n < 1000001; n++) {
				if (isPrime(n)) primeNumbers.add(n);
			}

			/*for (int num : primeNumbers) {
				System.out.println(num + "");
			}*/
			
			int counter = 0;
			
			for (int i = 2; i < 1000001; i++) {
				if (!primeNumbers.contains(i)) continue;
				int numberLength = String.valueOf(i).length();
				int rotationsTried = 1;
				
				int currentNumberState = i;
				boolean isStillPrime = true;
				while (rotationsTried < numberLength) {
					if (String.valueOf(currentNumberState).length() != String.valueOf(i).length()) {
						currentNumberState = currentNumberState * 10;
						//System.out.println("new rotated state: " + currentNumberState);
					} else {
						int lastNumber = currentNumberState / (int) Math.pow(10, numberLength-1);
						//System.out.println("lastnumber=" + lastNumber + " currentNumber=" + currentNumberState);
						currentNumberState = currentNumberState - (lastNumber * (int) Math.pow(10, numberLength-1));
						//System.out.println(currentNumberState);
						currentNumberState = currentNumberState * 10;
						//System.out.println(currentNumberState);
						currentNumberState = currentNumberState + lastNumber;
						//System.out.println("new rotated state: " + currentNumberState);
					}
					if (!primeNumbers.contains(currentNumberState)) {
						isStillPrime = false;
						break;
					}
					
					rotationsTried++;
				}
				
				if (isStillPrime) {
					counter++;
					System.out.println(i + "");
				}
			}
			
			System.out.println(counter);
	}
	
}
