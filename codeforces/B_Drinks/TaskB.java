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
  	Double sum = 0.0;
  	for (int i = 0; i < n; i++) {
  		sum += (1.0) * input.nextInt();
  	}
  	output.println(sum / n);
  }
}
