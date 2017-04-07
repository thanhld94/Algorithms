import java.io.*;
import java.util.*;

public class TaskA {
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tA.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    int test = in.nextInt();
    for (int t = 1; t <= test; t++) {
      char[] cakes = in.next().toCharArray();
      int k = in.nextInt();
      int count = 0;
      for (int i = 0; i <= cakes.length - k; i++) {
        if (cakes[i] == '-') {
          flip(cakes, i, k);
          count++;
        }
      }
      boolean check = true;
      for (char cake : cakes) {
        if (cake == '-') {
          check = false;
          break;
        }
      }
      if (check) {
        out.printf("Case #%d: %d\n", t, count);
      } else {
        out.printf("Case #%d: IMPOSSIBLE\n", t);
      }
    }
  }

  private void flip(char[] cakes, int pos, int k) {
    if (pos + k > cakes.length) 
      return;
    for (int i = pos; i < pos + k; i++) {
      cakes[i] = (cakes[i] == '-') ? '+' : '-';
    }
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
