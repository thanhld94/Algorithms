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
    int[] score = new int[n];
    for (int i = 0; i < n; i++) {
      score[i] = in.nextInt();
    }
    int[] price = new int[5];
    for (int i = 0; i < 5; i++) {
      price[i] = in.nextInt();
    }
    long[] count = new long[5];
    long remain = 0L;
    for (int i = 0; i < n; i++) {
      remain += score[i];
      while (true) {
        boolean found = false;
        int idx = 0;
        // looking for the most expansive exchangable reward
        for (int reward = 0; reward < price.length; reward++) {
          if (price[reward] <= remain) {
            found = true;
            if (price[reward] > price[idx]) 
              idx = reward;
          }
        }
        if (!found) break; // cannot exchange any reward 
        count[idx] += remain / price[idx];
        remain %= price[idx];
      }
    }
    for (long val : count) {
      out.print(val + " ");
    }
    out.println("\n" + remain);
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
