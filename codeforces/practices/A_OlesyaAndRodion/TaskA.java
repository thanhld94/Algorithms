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
  	int t = input.nextInt();
  	if (t == 10) {
  		if (n > 1) {
	  		output.print(1);
	  		for (int i = 1; i < n; i++) {
	  			output.print(0);
	  		}
	  	} else {
	  		output.print(-1);
	  	}
  		output.println();
  	} else {
  		for (int i = 0; i < n; i++) {
  			output.print(t);
  		}
  		output.println();
  	}
  }
}
