import java.io.PrintWriter;
import java.util.*;

public class TaskA {
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int t = input.nextInt();
    int s = input.nextInt();
    int x = input.nextInt() - t;

    if (x < 0) {
      output.println("NO");
      return;
    }

    if (x % s == 0) {
      output.println("YES");
    } else if (x % s == 1) {
      if (x / s > 0) {
        output.println("YES");
      } else {
        output.println("NO");
      }
    } else {
      output.println("NO");
    }
  }
}
