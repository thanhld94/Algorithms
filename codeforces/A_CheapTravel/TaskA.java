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
  	int m = input.nextInt();
  	int a = input.nextInt();
  	int b = input.nextInt();
  	if (a * m <= b) {
  		output.println(a * n);
  	} else {
  		int result = b * (n / m);
  		n %= m;
  		result += Math.min(a * n, b);
  		output.println(result);
  	}
  }
}
