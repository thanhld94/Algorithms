import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner in, PrintWriter out) {
    int n = in.nextInt();
    int result = 0;
    for (int i = 0; i < n; i++) {
      String s = in.next();
      if (s.charAt(1) == '+') {
        result++;
      } else {
        result--;
      }
    }
    out.println(result);
    out.close();
  }
}
