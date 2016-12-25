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

  private static final int MOD = (int) 1e8;

  public void solve(BScanner in, PrintWriter out) {
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int k1 = in.nextInt();
    int k2 = in.nextInt();
    // f[n1][n2][0] : use n1 footman, n2 horseman, and the last position is using footman
    // f[n1][n2][1] : use n1 footman, n2 horseman, and the last position is using horseman
    long[][][] f = new long[n1 + 1][n2 + 1][2];
    boolean[][][] calculated = new boolean[n1 + 1][n2 + 1][2];
    for (int i = 1; i <= Math.min(k1, n1); i++) {
      f[i][0][0] = 1;
      calculated[i][0][0] = true;
    }
    for (int i = 1; i <= Math.min(k2, n2); i++) {
      f[0][i][1] = 1;
      calculated[0][i][1] = true;
    }
    long result = (cal(n1, n2, k1, k2, 0, f, calculated) + cal(n1, n2, k1, k2, 1, f, calculated)) % MOD;
    out.println(result);
  }
  
  private long cal(int n1, int n2, int k1, int k2, int type, long[][][] f, boolean[][][] calculated) {
    //System.err.printf("At n1 = %d, n2 = %d, k1 = %d, k2 = %d, type = %d\n", n1, n2, k1, k2, type);
    if (calculated[n1][n2][type]) {
      return f[n1][n2][type];
    }
    if (type == 0) { // last position is a footman
      for (int k = 1; k <= k1 && k <= n1; k++) {
        f[n1][n2][type] = (f[n1][n2][type] + cal(n1 - k, n2, k1, k2, 1 - type, f, calculated)) % MOD;
      }
    } else { // last position is a horseman
      for (int k = 1; k <= k2 && k <= n2; k++) {
        f[n1][n2][type] = (f[n1][n2][type] + cal(n1, n2 - k, k1, k2, 1 - type, f, calculated)) % MOD;
      }
    }
    calculated[n1][n2][type] = true;
    return f[n1][n2][type];
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
