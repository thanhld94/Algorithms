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
  	for (int i = 0; i < n; i++) {
  		int angle = input.nextInt();
  		if (360 % (180 - angle) == 0) {
  			output.println("YES");
  		} else {
  			output.println("NO");
  		}
  	}
  }
}
