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
    String s1 = in.next();
    String s2 = in.next();
    List<Integer> divisors = getDivisors(s1.length());
    int count = 0;
    for (int divisor : divisors) {
      if (s2.length() % divisor != 0) continue;
      boolean same = true;
      for (int i = 0; i < divisor; i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          same = false;
          break;
        }
      }
      if (!same) continue;
      if (check(divisor, s1) && check(divisor, s2)) {
        count++;
      }
    }
    out.println(count);
  }

  private List<Integer> getDivisors(int x) {
    List<Integer> result = new ArrayList<Integer>();
    for (int i = 1; i * i <= x; i++) {
      if (x % i == 0) {
        result.add(i);
        if (x / i != i) {
          result.add(x / i);
        }
      }
    }
    return result;
  }

  private boolean check(int divisor, String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i % divisor)) {
        return false;
      }
    }
    return true;
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
