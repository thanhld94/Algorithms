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
  	String a = input.next();
  	String b = input.next();
  	int n = a.length();
  	if (b.length() != n) {
  		output.println("NO");
  		return;
  	}
  	for (int i = 0; i < n; i++) {
  		if (a.charAt(i) != b.charAt(n - i - 1)) {
  			output.println("NO");
  			return;
  		}
  	}
  	output.println("YES");
  }
}
