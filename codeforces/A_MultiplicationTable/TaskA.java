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
  	int x = input.nextInt();
  	int count = 0;
  	for (int i = 1; i <= n; i++) {
  		if (x % i == 0 && x / i <= n) {
  			count++;
  		}
  	}
  	output.println(count);
  }
}
