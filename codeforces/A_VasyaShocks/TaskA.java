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
  	int a = input.nextInt();
  	int b = input.nextInt();
  	int result = 0;
  	int rem = 0;
  	while (a > 0 || rem >= b) {
  		if (rem >= b) {
  			a++;
  			rem -= b;
  		}
  		result += a;
  		rem += a % b;
  		a /= b;
  	}
  	output.println(result);
  }
}
