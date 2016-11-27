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
    int n = in.nextInt();
    int k = in.nextInt();
    char[] line = in.next().toCharArray();
    int player = -1;
    int target = -1;
    for (int i = 0; i < n; i++) {
      if (line[i] == 'G') player = i;
      if (line[i] == 'T') target = i;
    }
    for (int i = player; i >= 0; i -= k) {
      if (line[i] == '#') break;
      if (line[i] == 'T') {
        out.println("YES");
        return;
      }
    }
    for (int i = player; i < n; i += k) {
      if (line[i] == '#') break;
      if (line[i] == 'T') {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
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
