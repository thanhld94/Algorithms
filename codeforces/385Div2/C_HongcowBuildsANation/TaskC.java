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

  int n, m, k;
  Node[] nodes = new Node[1111];
  int[] governments = new int[1111];
  boolean[] visited = new boolean[1111];

  public void solve(BScanner in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node();
    }
    for (int i = 0; i < k; i++) {
      governments[i] = in.nextInt() - 1;
    }
    for (int i = 0; i < m; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      nodes[u].adj.add(v);
      nodes[v].adj.add(u);
    }
    List<Integer> counts = new ArrayList<Integer>();
    for (int i = 0; i < k; i++) {
      counts.add(visit(governments[i]));
    }
    int rem = 0;
    for (int i = 0; i < n; i++) 
      if (!visited[i]) rem++;
    Collections.sort(counts, Collections.reverseOrder());
    long total = combinations(counts.get(0) + rem);
    for (int i = 1; i < counts.size(); i++) {
      total += combinations(counts.get(i));
    }
    out.println(total - m);
  }

  private long combinations(int x) {
    return 1L * x * (x - 1) / 2;
  }

  private int visit(int idx) {
    int total = 1;
    visited[idx] = true;
    for (int next : nodes[idx].adj) {
      if (!visited[next]) {
        total += visit(next);
      }
    }
    return total;
  }

  private class Node {
    List<Integer> adj;

    private Node() {
      adj = new ArrayList<Integer>();
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
