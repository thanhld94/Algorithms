import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
  public static void main(String[] args) {
    TaskB tb = new TaskB();
    tb.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    int nTest = input.nextInt();
    for (int i = 0; i < nTest; i++) {
      int n = input.nextInt();
      n += 2;
      if (n % 2 == 1) {
        output.println(2);
      } else {
        output.println(1);
      }
    }
    output.close();
  }
}
