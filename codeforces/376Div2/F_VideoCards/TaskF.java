import java.io.*;
import java.util.*;

public class TaskF {
  public static void main(String[] args) {
    TaskF tF = new TaskF();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tF.solve(in, out);
    out.close();
  }

  public static final int N = 200000;
  int[] count = new int[N + 1];
  int[] countGreaterOrEquals = new int[N + 1];

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      count[in.nextInt()]++;
    }

    // count all numbers that are greater than or equals to x
    countGreaterOrEquals[N] = count[N];
    for (int val = N - 1; val > 0; val--) {
      countGreaterOrEquals[val] = countGreaterOrEquals[val + 1] + count[val];
    }

    // finding the maximum power
    long maxPower = 0;
    for (int lead = 1; lead <= N; lead++) {
      if (count[lead] == 0) continue;
      long totalPower = 0;
      for (int power = lead; power <= N; power += lead) {
        int nextPower = (power + lead <= N) ? countGreaterOrEquals[power + lead] : 0;
        totalPower += 1L * (countGreaterOrEquals[power] - nextPower) * power;
      }
      maxPower = Math.max(maxPower, totalPower);
    }
    out.println(maxPower);
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
