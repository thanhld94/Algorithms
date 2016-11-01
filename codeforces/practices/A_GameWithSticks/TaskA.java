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
  	boolean win = (Math.min(n,m) % 2 == 1);
  	if (win) {
  		output.println("Akshat");
  	} else {
  		output.println("Malvika");
  	}
  }
}
