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

  private static final int maxn = 100111;

  int[] c = new int[maxn];
  List<List<Integer>> adj = new ArrayList<List<Integer>>();
  Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt() - 1;
      adj.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(c[i])) {
        map.put(c[i], new HashSet<Integer>());
      }
      for (int next : adj.get(i)) {
        if (c[i] != c[next]) {
          map.get(c[i]).add(c[next]);
        }
      }
    }
    int idx = -1;
    for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
      //System.err.printf("Q(%d) = %d\n", entry.getKey(), entry.getValue().size());
      if (idx == -1) {
        idx = entry.getKey();
      } else {
        if (map.get(idx).size() < entry.getValue().size() 
              || (map.get(idx).size() == entry.getValue().size() && idx > entry.getKey())) {
          idx = entry.getKey();
        }
      }
    }
    out.println(idx + 1);
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
