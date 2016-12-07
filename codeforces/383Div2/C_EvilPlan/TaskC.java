import java.io.*;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tC.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int[] crush = new int[n];
    for (int i = 0; i < n; i++) {
      crush[i] = in.nextInt() - 1;
    }
    int[] count = new int[n];
    List<Integer> values = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (count[i] != 0) continue;
      count[i] = 1;
      int value = -1;
      value = visit(i, crush, count);
      if (value == -1) {
        out.println(-1);
        return;
      }
      if (value % 2 == 0) 
        values.add(value / 2);
      else 
        values.add(value);
    }
    long result = 1;
    for (int value : values) {
      result = result * value / gcd(result, 1L * value);
    }
    out.println(result);
  }

  private int visit(int idx, int[] crush, int[] count) {
    int next = crush[idx];
    if (count[next] == 0) {
      count[next] = count[idx] + 1;
      return visit(next, crush, count);
    }
    if (count[next] != 1) 
      return -1;
    return count[idx];
  }

  private long gcd(long a, long b) {
    if (a % b == 0) return b;
    return gcd(b, a % b);
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
