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

  private static final int MAXN = 3111;

  boolean[][] hasEdge = new boolean[MAXN][MAXN];
  int[][] count = new int[MAXN][MAXN];

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      hasEdge[u][v] = true;
    }
    for (int a = 0; a < n; a++) {
      for (int b = 0; b < n; b++) {
        if (!hasEdge[a][b]) continue;
        for (int c = 0; c < n; c++) {
          if (hasEdge[b][c] && c != a) {
            count[a][c]++;
          }
        }
      }
    }
    long result = 0;
    for (int u = 0; u < n; u++) {
      for (int v = 0; v < n; v++) {
        result += 1L * count[u][v] * (count[u][v] - 1) / 2;
      }
    }
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
