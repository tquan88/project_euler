package sandbox;

public class Euler34 {

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
	
	public void getAnswer() {
		int answer = 0;
		for (int i = 3; i < 2147483646; i++) {
			int currentNumber = i;
			int runningCount = 0;
			while (currentNumber > 0) {
				runningCount += factorials[currentNumber % 10];
				currentNumber = currentNumber / 10;
			}
			
			if (i == runningCount) {
				System.out.println(i);
				answer += i;
			}
		}
		System.out.println(answer);
	}
	
	
}
