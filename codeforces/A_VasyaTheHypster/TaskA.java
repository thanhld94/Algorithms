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
  	output.print(Math.min(a,b) + " ");
  	int result = (Math.max(a,b) - Math.min(a,b)) / 2;
  	output.println(result);
  }
}
