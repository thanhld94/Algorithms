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

  public static final int ZERO = 1500;

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    boolean[] has = new boolean[1001];
    for (int i = 0; i < k; i++) {
      has[in.nextInt()] = true;
    }
    List<Integer> edges = new ArrayList<Integer>();
    for (int edge = 0; edge <= 1000; edge++) {
      if (has[edge]) {
        edges.add(edge - n);
      }
    }
    out.println(getMinVolume(n, k, edges));
  }

  private int getMinVolume(int n, int k, List<Integer> edges) {
    boolean[] visited = new boolean[3000];
    int[] volume = new int[3000];
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(ZERO);
    while (queue.size() != 0) {
      int top = queue.poll();
      for (int edge : edges) {
        int next = top + edge;
        if (next < 0 || next >= 3000) {
          continue;
        }
        if (!visited[next]) {
          visited[next] = true;
          volume[next] = volume[top] + 1;
          queue.add(next);
        }
        if (next == ZERO) {
          return volume[next];
        }
      }
    }
    return -1;
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
