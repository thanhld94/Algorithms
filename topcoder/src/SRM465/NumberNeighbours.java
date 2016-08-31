import java.util.*;

public class NumberNeighbours
{
	public int numPairs(int[] numbers)
	{
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (check(numbers[i], numbers[j])) {
					count++;
				}
			}
		}
		return count;
	}
	
	private boolean check(int a, int b) {
		int[] digits = new int[10];
		while (a > 0) {
			digits[a % 10]++;
			a /= 10;
		}
		while (b > 0) {
			digits[b % 10]--;
			if (digits[b % 10] < 0 && b % 10 != 0) {
			  return false;
			}
			b /= 10;
		}
		for (int i = 1; i < 10; i++) {
			if (digits[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new NumberNeighbours().numPairs(new int[]{10, 1, 100, 20, 2, 3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new NumberNeighbours().numPairs(new int[]{204, 42, 40020, 200});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new NumberNeighbours().numPairs(new int[]{1, 10, 100, 1000, 10000, 100000, 1000000});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 21;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new NumberNeighbours().numPairs(new int[]{3, 33, 333, 3333});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new NumberNeighbours().numPairs(new int[]{1024, 4021, 204, 303, 33, 603, 36, 55, 505});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
