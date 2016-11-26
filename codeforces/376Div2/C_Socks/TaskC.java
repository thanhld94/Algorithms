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
  Node[] nodes;
  boolean[] visited;
  int result = 0;

  public void solve(BScanner in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();

    nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(in.nextInt() - 1);
    }

    for (int i = 0; i < m; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      nodes[u].adj.add(v);
      nodes[v].adj.add(u);
    }

    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        bfs(i);
      }
    }
    out.println(result);
  }

  private void bfs(int s) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    visited[s] = true;
    int sum = 1;
    int max = 1;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(nodes[s].color, 1);
    while (queue.size() > 0) {
      int top = queue.poll();
      for (int next : nodes[top].adj) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
          // update
          sum++;
          int color = nodes[next].color;
          if (map.containsKey(color)) {
            map.put(color, map.get(color) + 1);
          } else {
            map.put(color, 1);
          }
          max =  Math.max(max, map.get(color));
        }
      }
    }
    result += (sum - max);
  }

  private class Node {
    private int color;
    private Set<Integer> adj;

    private Node(int color) {
      this.color = color;
      adj = new HashSet<Integer>();
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
