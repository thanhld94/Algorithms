import java.io.*;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tB.solve(in, out);
    out.close();
  }

  private static final int MOD = (int) 1e9 + 7;

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    long[][] f = new long[n + 1][k + 1];
    for (int i = 0; i <= n; i++) 
      f[i][1] = 1;
    for (int i = 1; i <= n; i++) {
      for (int length = 1; length < k; length++) {
        for (int ii = i; ii <= n; ii += i) {
          f[ii][length + 1] = (f[ii][length + 1] + f[i][length]) % MOD;
        }
      }
    }
    long result = 0;
    for (int i = 1; i <= n; i++) 
      result = (result + f[i][k]) % MOD;
    out.println(result);
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
