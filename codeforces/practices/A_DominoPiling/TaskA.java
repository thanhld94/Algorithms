import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    output.println((n * m)/2);
    output.close();
  }
}
