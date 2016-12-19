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
    char[] text = in.next().toCharArray();
    int[] count = new int[4];
    for (int i = 0; i < text.length; i++) {
      if (text[i] == '?') continue;
      if (text[i] == 'A') count[0]++;
      if (text[i] == 'C') count[1]++;
      if (text[i] == 'G') count[2]++;
      if (text[i] == 'T') count[3]++;
    }

    for (int i = 0; i < text.length; i++) {
      if (text[i] != '?') continue;
      int idx = 0;
      for (int j = 1; j < 4; j++) 
        if (count[j] < count[idx]) idx = j;
      count[idx]++;
      if (idx == 0) text[i] = 'A';
      else if (idx == 1) text[i] = 'C';
      else if (idx == 2) text[i] = 'G';
      else text[i] = 'T';
    }
    for (int i = 1; i < 4; i++)
      if (count[i] != count[0]) {
        out.println("===");
        return;
      }
    out.println(new String(text));
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
