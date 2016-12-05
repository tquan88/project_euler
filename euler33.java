package sandbox;

import java.util.HashSet;
import java.util.Set;

public class euler33 {
	
	public void getAnswer () {
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				if (a % 10 == 0 || b % 10 == 0) continue;
				
				String stringToCheckA = a + "";
				String stringToCheckB = b + "";
				
				String stringToCheck = stringToCheckA + stringToCheckB;
				
				char[] chars = stringToCheck.toCharArray();
				Set<Character> charSet = new HashSet<Character>();
				char duplicate = ' '; 
				for (char c : chars) {
					if (!charSet.contains(c)) {
						charSet.add(c);
					} else {
						duplicate = c;
					}
				}
				if (duplicate != ' ' && charSet.size() == 3) {
					try {
						stringToCheckA = stringToCheckA.replace(duplicate, ' ').replace('0', ' ').trim();
						stringToCheckB = stringToCheckB.replace(duplicate, ' ').replace('0', ' ').trim();
						
						if (stringToCheckA.length() > 0 && stringToCheckB.length() > 0) {
							int simpA = Integer.parseInt(stringToCheckA);
							int simpB = Integer.parseInt(stringToCheckB);
							
							if ((double) simpA / simpB == ((double)a / b) && ((double)a / b) < 1) {
								System.out.println(a + "/" + b + " = " + stringToCheckA + "/" + stringToCheckB);
							}
						}
					} catch (NumberFormatException e) {
						//System.out.println(a + "/" + b + " = " + stringToCheckA + "/" + stringToCheckB);
					}
				}
			}
		}
	}
	
}
