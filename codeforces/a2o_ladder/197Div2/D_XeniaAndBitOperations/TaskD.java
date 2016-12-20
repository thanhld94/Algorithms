import java.io.*;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tD.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] seq = new int[n + 1][(1 << n)];
    for (int i = 0; i < (1 << n); i++) {
      seq[0][i] = in.nextInt();
    }
    // precaculate sequence
    int op = 0; // 0 = or, 1 = xor
    for (int lv = 1; lv <= n; lv++) {
      int size = (1 << (n - lv));
      for (int idx = 0; idx < size; idx++) {
        seq[lv][idx] = calculate(seq[lv - 1][idx * 2], seq[lv - 1][idx * 2 + 1], op);
      }
      op = 1 - op;
    }
    // update and query
    for (int query = 0; query < m; query++) {
      int pos = in.nextInt() - 1;
      int val = in.nextInt();
      seq[0][pos] = val;
      // update consequence levels
      pos /= 2;
      int flag = 0;
      for (int lv = 1; lv <= n; lv++) {
        seq[lv][pos] = calculate(seq[lv - 1][pos * 2], seq[lv - 1][pos * 2 + 1], flag);
        flag = 1 - flag;
        pos /= 2;
      }
      out.println(seq[n][0]);
    }
  }

  private int calculate(int a, int b, int flag) {
    return (flag == 0) ? a | b : a ^ b;
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
