package sandbox;

import java.util.LinkedHashSet;
import java.util.Set;

public class euler32 {
	public void getAnswer() {
		Set<Integer> resultsSoFar = new LinkedHashSet<Integer>();
		
		int counter = 0;
		
		for (int a = 1; a < 100000; a++) {
			for (int b = 1; b < 100000; b++) {
				int product = a*b; 
				if (!resultsSoFar.contains(product)) {
					
					String stringToCheck = a + "" + b + "" + product + "0";
					
					if (stringToCheck.length() == 10) {
						
						char[] chars = stringToCheck.toCharArray();
						
						Set<Character> charSet = new LinkedHashSet<Character>();
						for (char c : chars) {
						    charSet.add(c);
						}
						
						if (charSet.size() == 10) {
							System.out.println(a + " + " + b + " = " + product);
							resultsSoFar.add(product);
							counter += product;
							System.out.println("Product: " + counter);
						}
					}
				}
			}
		}
	}
}
