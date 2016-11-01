import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
 
  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int result = 0;
    for (int i = 0; i < n; i++) {
      int agree = 0;
      for (int j = 0; j < 3; j++) {
        agree += input.nextInt();
      }
      if (agree >= 2) result++;
    }
    output.println(result);
    output.close();
  }
}
