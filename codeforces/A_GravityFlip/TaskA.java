import java.io.PrintWriter;
import java.util.Arrays;
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
  	int[] cols = new int[n];
  	for (int i = 0; i < n; i++) {
  		cols[i] = input.nextInt();
  	}
  	Arrays.sort(cols);
  	for (int col : cols) {
  		output.print(col + " ");
  	}
  	output.println();
  }
}
