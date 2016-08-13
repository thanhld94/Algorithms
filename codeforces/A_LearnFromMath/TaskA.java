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
  	boolean[] composite = new boolean[n+1];
  	composite[1] = true;
  	for (int i = 2; i <= n; i++) {
  		if (!composite[i]) {
  			for (int j = i + i; j <= n; j += i) {
  				composite[j] = true;
  			}
  		}
  	}
  	for (int i = 4; i <= n-4; i++) {
  		if (composite[i] && composite[n - i]) {
  			output.println(i + " " + (n - i));
  			return;
  		}
  	}
  }
}
