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
  	int result = 0;
  	int min = Integer.MAX_VALUE;

  	for (int i = 0; i < n; i++) {
  		int a = input.nextInt();
  		int b = input.nextInt();
  		min = Math.min(min, b);
  		result += a * min;
  	}
  	output.println(result);
  }
}
