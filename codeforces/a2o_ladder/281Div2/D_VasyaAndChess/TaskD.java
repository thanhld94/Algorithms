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
    if (n % 2 != 0) {
      out.println("black");
    } else {
      out.println("white");
      out.println("1 2");
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
