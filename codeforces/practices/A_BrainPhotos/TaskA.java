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
  	for (int i = 0; i < n; i++) {
  		for (int j = 0; j < m; j++) {
  			String color = input.next();
  			if (color.equals("C") || color.equals("M") || color.equals("Y")) {
  				output.println("#Color");
  				return;
  			}
  		}
  	}
  	output.println("#Black&White");
  }
}
