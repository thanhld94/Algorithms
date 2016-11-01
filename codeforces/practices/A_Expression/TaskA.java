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
  	int c = input.nextInt();
  	int result = a + b + c; // => a + b + c ---- a + b * c ---- a * b + c ---- a * b * c
		result = Math.max(result, (a + b) * c);
  	result = Math.max(result, a + b * c);
  	result = Math.max(result, a * (b + c));
  	result = Math.max(result, a * b + c);
  	result = Math.max(result, a * b * c);
  	output.println(result);
  }
}
