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
  	int count = 0;
  	int next = 0;
  	int idx = 1;
  	while (true) {
  		next += (idx++);
  		count += next;
  		// output.println(idx + " " + next + " " + count);
  		if (count > n) {
  			break;
  		}
  		result++;
  	}
  	output.println(result);
  }
}
