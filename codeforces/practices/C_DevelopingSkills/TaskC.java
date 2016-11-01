import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int k = input.nextInt();
    int[] values = new int[n];
    int result = 0;
    for (int i = 0; i < n; i++) {
      int lv = input.nextInt();
      values[i] = lv % 10;
      result += lv / 10;
    }

    Arrays.sort(values);

    for (int i = n - 1; i >= 0; i--) {
      int rem = 10 - values[i];
      values[i] += Math.min(rem, k);
      k = (k > rem) ? k - rem : 0;
      if (values[i] == 10) {
        result++;
      }
    }

    if (k > 0) {
      result += (k / 10);
    }
    output.println(Math.min(n * 10, result));
  }
}
