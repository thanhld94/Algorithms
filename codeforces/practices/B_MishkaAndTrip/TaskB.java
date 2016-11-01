import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB{
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int k = input.nextInt();
  	int[] c = new int[n + 2];
  	long sum = 0;
  	for (int i = 1; i <= n; i++) {
  		c[i] = input.nextInt();
  		sum += c[i];
  	}
  	c[0] = c[n];
  	c[n + 1] = c[1];

  	boolean[] capital = new boolean[n + 2];
  	for (int i = 0; i < k; i++) {
  		int cap = input.nextInt();
  		capital[cap] = true;
  	}
  	capital[0] = capital[n];
  	capital[n + 1] = capital[1];

  	long result = 0;
  	for (int i = 1; i <= n; i++) {
			if (!capital[i] && !capital[i + 1]) {
				result += (1L) * c[i] * c[i + 1];
  		} if (capital[i]) {
  			result += (sum - c[i]) * c[i];
  			sum -= c[i];
  		}
  	}
  	
  	output.println(result);
  }
}
