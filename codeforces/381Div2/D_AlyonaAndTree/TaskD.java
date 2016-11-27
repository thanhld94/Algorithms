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

  private static final int MAXN = 200111;
  
  int n;
  int[] count = new int[MAXN];
  long[] distanceFromRoot = new long[MAXN];
  long[] distanceFromParent = new long[MAXN];
  long[] radius = new long[MAXN];
  List<List<Integer>> adj = new ArrayList<List<Integer>>();

  // stack
  int[] stack = new int[MAXN];
  int slast = -1;

  public void solve(BScanner in, PrintWriter out) {
    n = in.nextInt();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
      radius[i] = in.nextLong();
    }
    for (int i = 1; i < n; i++) {
      int p = in.nextInt() - 1;
      long w = in.nextLong();
      adj.get(p).add(i);
      distanceFromParent[i] = w;
    }

    visit(0); //dfs
    for (int i = 0; i < n; i++) {
      int total = 0;
      for (int child : adj.get(i)) {
        total += count[child];
      }
      out.print(total + " ");
    }
    out.println();
  }

  private void visit(int node) {
    // not root and can go to parent
    if (node != 0 && distanceFromParent[node] <= radius[node]) {
      int ancestor = findAncestor(node);
      count[ancestor]--;
      count[node]++;
    }
    stack[++slast] = node; // add to stack
    // updating child
    for (int child : adj.get(node)) {
      distanceFromRoot[child] = distanceFromRoot[node] + distanceFromParent[child];
      visit(child);
      count[node] += count[child];
    }
    slast--; // pop out from stack
  }

  // finding the furthest reachable ancestor
  private int findAncestor(int current) {
    int low = 0;
    int high = slast;
    int ancestor = stack[high];
    while (low <= high) {
      int mid = low + (high - low)/2;
      int node = stack[mid];
      if (distanceFromRoot[current] - distanceFromRoot[node] <= radius[current]) {
        ancestor = stack[mid];
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ancestor;
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
