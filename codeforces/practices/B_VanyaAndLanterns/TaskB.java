import java.io.PrintWriter;
import java.util.Scanner;

import java.util.Arrays;

public class TaskB{

	private static final double EPSILON = 0.000000001;

  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n =  input.nextInt();
  	int len = input.nextInt();
  	int[] a = new int[n];
  	for (int i = 0; i < n; i++) {
  		a[i] = input.nextInt();
  	}
  	Arrays.sort(a);
  	int max = Math.max(a[0] - 0, len - a[n-1]);
  	max *= 2;
  	for (int i = 1; i < n; i++) {
  		max = Math.max(max, a[i] - a[i-1]);
  	}
  	output.println((1.0) * max / 2);
  }
}
