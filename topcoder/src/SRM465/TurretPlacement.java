import java.util.*;

public class TurretPlacement
{
	public long count(int[] x, int[] y)
	{
		long count = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < y.length; j++) {
				count += getCount(x[i], y[i], x[j], y[j]);
			}
		}
		return count;
	}
	
	private long getCount(int xi, int yi, int xj, int yj) {
		double len = 1.0 * (xi - xj) * (xi - xj) + (yi - yj) * (yi - yj);
		len = Math.sqrt(len) * 2;
		int result = 0;
		for (int i = 1; i <= (int)len; i++) {
			result += (len - i);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new TurretPlacement().count(new int[]{0,2}, new int[]{0,2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 10L;
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
		answer = new TurretPlacement().count(new int[]{0,1,2}, new int[]{0,1,0});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8L;
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
		answer = new TurretPlacement().count(new int[]{1,2,3,0}, new int[]{-1,-5,-7,100});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 65137L;
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
		answer = new TurretPlacement().count(new int[]{9998,-10000,10000,0}, new int[]{9998,10000,10000,0});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2799564895L;
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
