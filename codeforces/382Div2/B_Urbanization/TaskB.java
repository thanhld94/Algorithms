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
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int[] wealth = new int[n];
    for (int i = 0; i < n; i++) {
      wealth[i] = in.nextInt();
    }
    Arrays.sort(wealth);
    double result = 0;
    {
      long sum1 = 0;
      long sum2 = 0;
      int idx = n - 1;
      for (int i = 0; i < n1; i++) {
        sum1 += wealth[idx--];
      }
      for (int i = 0; i < n2; i++) {
        sum2 += wealth[idx--];
      }
      result = (1.0) * sum1 / n1 + (1.0) * sum2 / n2;
    }
    {
      long sum1 = 0;
      long sum2 = 0;
      int idx = n - 1;
      for (int i = 0; i < n2; i++) {
        sum1 += wealth[idx--];
      }
      for (int i = 0; i < n1; i++) {
        sum2 += wealth[idx--];
      }
      result = Math.max(result, (1.0) * sum1 / n2 + (1.0) * sum2 / n1);
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
