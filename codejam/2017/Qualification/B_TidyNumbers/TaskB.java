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
      char[] chardigits = in.next().toCharArray();
      int[] digits = new int[chardigits.length];
      for (int i = 0; i < digits.length; i++) {
        digits[i] = chardigits[i] - '0';
      }
      transform(digits);
      out.printf("Case #%d: ", t);
      print(digits, out);
    }
  }

  private void transform(int[] digits) {
    int idx = -1;
    for (int i = 0; i < digits.length - 1; i++) {
      if (digits[i] > digits[i + 1]) {
        digits[i]--;
        for (int j = i + 1; j < digits.length; j++) {
          digits[j] = 9;
        }
        transform(digits);
        return;
      }
    }
  }

  private void print(int[] digits, PrintWriter out) {
    int idx = 0;
    while (idx < digits.length && digits[idx] == 0) 
      idx++;
    if (idx == digits.length) 
      out.print(0);
    for (int i = idx; i < digits.length; i++) {
      out.print(digits[i]);
    }
    out.println();
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
