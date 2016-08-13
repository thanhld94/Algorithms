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
  	int[] totals = new int[3];
  	for (int i = 0; i < n; i++) {
  		for (int j = 0; j < 3; j++) 
  			totals[j] += input.nextInt();
  	}
  	for (int total : totals) {
  		if (total != 0) {
  			output.println("NO");
  			return;
  		}
  	}
  	output.println("YES");
  }
}
