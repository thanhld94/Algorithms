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
  	int n1 = input.nextInt();
  	int n2 = input.nextInt();
  	if (n1 > n2) {
  		output.println("First");
  	} else {
  		output.println("Second");
  	}
  }
}
