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
  	long n = input.nextLong();
  	long m = input.nextLong();
  	long current = 1;
  	long result = 0;
  	for (long i = 0; i < m; i++) {
  		long task = input.nextLong();
  		if (current <= task) {
  			result += (task - current);
  		} else {
  			result += (n - current + task);
  		}
  		current = task;
  	}
  	output.println(result);
  }
}
