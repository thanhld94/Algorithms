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
    int T = in.nextInt();
    for (int test = 1; test <= T; test++) {
      int N = in.nextInt();
      if (N == 0) {
        out.printf("Case #%d: INSOMNIA\n", test);
      } else {
        out.printf("Case #%d: %d\n", test, process(N));
      }
    }
  }

  private int process(int x) {
    int num = x;
    boolean[] has = new boolean[10];
    while (true) {
      for (int digit : getDigits(num)) {
        has[digit] = true;
      }
      boolean found = true;
      for (boolean val : has) {
        if (!val) {
          found = false;
        }
      }
      if (found) {
        break;
      }
      num += x;
    }
    return num;
  }

  private List<Integer> getDigits(int num) {
    int tmp = num;
    List<Integer> result = new ArrayList<Integer>();
    // num cannot be 0
    while (tmp > 0) {
      int digit = tmp % 10;
      result.add(digit);
      tmp /= 10;
    }
    return result;
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
