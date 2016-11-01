import java.io.PrintWriter;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] t = new int[n];
    int result = 0;
    for (int i = 0; i < n; i++) {
      t[i] = input.nextInt();
      result += t[i];
    }

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        if (i >= 3) {
          result = Math.max(result, getValue(t, i));
        }
        if (i * i != n && n/i >= 3) {
          result = Math.max(result, getValue(t, n/i));
        }
      }
    }
    output.println(result);
  }

  private int getValue(int[] t, int nNodes) {
    int result = Integer.MIN_VALUE;
    int gap = t.length / nNodes;
    for (int start = 0; start < gap; start++) {
      int total = 0;
      int idx = start;
      for (int i = 0; i < nNodes; i++) {
        idx = (idx < t.length) ? idx : idx - t.length;
        total += t[idx];
        idx += gap;
      }
      result = Math.max(result, total);
    }
    return result;
  }
}
