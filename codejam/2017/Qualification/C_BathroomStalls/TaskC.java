import java.io.*;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tC.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    int test = in.nextInt();
    for (int t = 1; t <= test; t++) {
      int n = in.nextInt();
      int k = in.nextInt();
      int lv = log2(k);
      if (k == 1) {
        out.printf("Case #%d: %d %d\n", t, n/2, (n - 1)/2);
        continue;
      }
      double avg = 1.0 * (n - (1 << lv) + 1) / (1 << lv);
      //out.printf("lv = %d, avg = %.2f\n", lv, avg);
      int high = (int) Math.ceil(avg);
      int low = (int) Math.floor(avg);
      int nlow = (1 << (lv + 1)) - 1 - k;
      int nhigh = (1 << lv) - nlow;
      int val = high;
      if (nhigh * high + nlow * low + (1 << lv) - 1 > n) {
        val = low;
      }
      //out.printf("low = %d, high = %d, nlow = %d, nhigh = %d, val = %d\n", low, high, nlow, nhigh, val);
      out.printf("Case #%d: %d %d\n", t, val/2, (val - 1)/2);
    }
  }

  private int log2(int x) {
    return (int) (Math.log(1.0 * x) / Math.log(2.0));
  }

  private static class BScanner {
    private BufferedReader input;
    private StringTokenizer st;

    private BScanner() {
      input = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(input.readLine());
        } catch (IOException e) {
          System.err.println("No more token");
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    private int nextInt() {
      return Integer.parseInt(next());
    }

    private long nextLong() {
      return Long.parseLong(next());
    }

    private double nextDouble() {
      return Double.parseDouble(next());
    }

    private String nextLine() {
      String line = "";
      try {
        line = input.readLine();
      } catch (Exception e) {
        System.err.println("No more lines");
        e.printStackTrace();
      }
      return line;
    }
  }
}
