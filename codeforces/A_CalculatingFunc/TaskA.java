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
  	long n = input.nextLong();
  	if (n % 2 == 0) {
  		output.println(n/2);
  	} else {
  		output.println(-1 - n/2);
  	}
  }
}
