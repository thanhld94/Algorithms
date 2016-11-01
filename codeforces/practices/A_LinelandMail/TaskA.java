import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int[] a = new int[n];
  	for (int i = 0; i < n; i++) {
  		a[i] = input.nextInt();
  	}

  	output.println((a[1] - a[0]) + " " + (a[n-1] - a[0]));
  	for (int i = 1; i < n - 1; i++) {
  		output.print(Math.min(a[i] - a[i - 1], a[i + 1] - a[i]));
  		output.print(" ");
  		output.println(Math.max(a[i] - a[0], a[n - 1] - a[i]));
  	}
  	output.println((a[n - 1] - a[n - 2]) + " " + (a[n - 1] - a[0]));
  }
}
