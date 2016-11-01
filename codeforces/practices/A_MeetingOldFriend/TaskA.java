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
    long l1 = input.nextLong();
    long r1 = input.nextLong();
    long l2 = input.nextLong();
    long r2= input.nextLong();
    long k = input.nextLong();
    long l = Math.max(l1, l2);
    long r = Math.min(r1, r2);
    if (l > r) {
      output.println(0);
    } else {
      long result = r - l + 1;
      if (l <= k && k <= r) {
        result--;
      }
      output.println(result);
    }
  }
}
