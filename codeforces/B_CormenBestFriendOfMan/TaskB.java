import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int k = input.nextInt();
    int[] a = new int[n];
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
      result[i] = a[i];
    }

    int total = 0;
    for (int i = 1; i < n; i++) {
      result[i] = result[i] + Math.max(0, k - result[i - 1] -result[i]);
      total += (result[i] - a[i]);
    }
    output.println(total);
    for (int val : result) {
      output.print(val + " ");
    }
    output.println();
  }
}
