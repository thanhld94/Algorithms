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
  	String text = input.next();
  	int count = 0;
  	for (int i = 0; i < n; i++) {
  		if (text.charAt(i) == '0') count++;
  		else count--;
  	}
  	output.println(Math.abs(count));
  }
}
