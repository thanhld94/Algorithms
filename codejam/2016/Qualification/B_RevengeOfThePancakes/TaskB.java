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
    int test = in.nextInt();
    for (int t = 1; t <= test; t++) {
      char[] cakes = in.next().toCharArray();
      int index = cakes.length - 1;
      int count = 0;
      int target = 0;
      while (index >= 0) {
        if (encode(cakes[index]) != target) {
          index--;
          continue;
        }
        count++;
        index--;
        while (index >= 0 && encode(cakes[index]) == target) {
          index--;
        }
        target = 1 - target;
      }
      out.printf("Case #%d: %d\n", t, count);
    }
  }

  private int encode(char c) {
    return (c == '+') ? 1 : 0;
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
