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
  	int previous = input.nextInt();
  	int result = 1;
  	int currentCount = 1;
  	for (int i = 1; i < n; i++) {
  		int current = input.nextInt();
  		if (current >= previous) {
  			currentCount++;
  			result = Math.max(result, currentCount);
  		} else {
  			currentCount = 1;
  		}
  		previous = current;
  	}
  	output.println(result);
  }
}
