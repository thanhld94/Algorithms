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
  	int[][] f = new int[n][n];
  	for (int i = 0; i < n; i++) {
  		f[0][i] = f[i][0] = 1;
  	}
  	for (int i = 1; i < n; i++) {
  		for (int j = 1; j < n; j++) {
  			f[i][j] = f[i-1][j] + f[i][j-1];
  		}
  	}
  	output.println(f[n-1][n-1]);
  }
}
