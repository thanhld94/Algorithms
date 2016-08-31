import java.util.*;

public class ZigZag
{
	public int longestZigZag(int[] sequence)
	{
		int n = sequence.length;		int[][] count = new int[n][2];
		count[0][0] = count[0][1] = 1;
		for (int i = 1; i < n; i++) {
			count[i][0] = count[i][1] = 1;
			for (int j = 0; j < i; j++) {
				if (sequence[i] > sequence[j]) {
					count[i][1] = Math.max(count[i][1], count[j][0] + 1);
				} else if (sequence[i] < sequence[j]) {
					count[i][0] = Math.max(count[i][0], count[j][1] + 1);
				}
			}
		}	
		return Math.max(count[n - 1][0], count[n - 1][1]);
	}
	
	// get(i,0) => Max get(j,1) + 1 such that a[i] < a[j]
	// get(i,1) => Max get(j,0) + 1 such that a[i] > a[j]
	// get(i) => Max (get(i,0), get(i,1)
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[]{ 1, 7, 4, 9, 2, 5 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new ZigZag().longestZigZag(new int[]{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
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
		answer = new ZigZag().longestZigZag(new int[]{ 44 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new ZigZag().longestZigZag(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new ZigZag().longestZigZag(new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new ZigZag().longestZigZag(new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244 });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 36;
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
