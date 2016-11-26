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

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int leftOver = 0;

    for (int i = 0; i < n; i++) {
      int numberOfPizzas = in.nextInt();
      if (numberOfPizzas < leftOver) {
        out.println("NO");
        return;
      }
      leftOver = (numberOfPizzas - leftOver) % 2;
    }
    if (leftOver == 1) {
      out.println("NO");
      return;
    }
    out.println("YES");
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
