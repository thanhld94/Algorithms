import java.io.PrintWriter;
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] a = new int[n];
    long[] sum = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
      sum[i] = (i > 0) ? sum[i - 1] : 0L;
      sum[i] += a[i];
    }
    if (n < 3) {
      output.println(0);
      return;
    }

    long result = 0;
    Map<Long, Integer> map = new HashMap<Long, Integer>();
    map.put(sum[0], 1);
    for (int i = 1; i < n - 1; i++) {
      long target = sum[n - 1] - sum[i];
      if (sum[i] % 2 == 0 && sum[i] / 2 == target) {
        int count = (map.containsKey(target)) ? map.get(target) : 0;
        result = result + count;
      }
      // update map
      if (map.containsKey(sum[i])) {
        map.put(sum[i], map.get(sum[i]) + 1);
      } else {
        map.put(sum[i], 1);
      }
    }
    output.println(result);
  }
}
