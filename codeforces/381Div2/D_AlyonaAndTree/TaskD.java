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

  int n;
  long[] distance = new long[200111];
  long[] radius = new long[200111];
  long[] distanceToParent = new long[200111];
  int[] count = new int[200111];
  List<List<Integer>> adj = new ArrayList<List<Integer>>();

  // stack
  int[] stack = new int[200111];
  int stackFirst = 0; 
  int stackLast = -1;

  public void solve(BScanner in, PrintWriter out) {
    n = in.nextInt();
    for (int i = 0; i < n; i++) {
      radius[i] = in.nextLong();
      adj.add(new ArrayList<Integer>());
    }

    for (int i = 1; i < n; i++) {
      int p = in.nextInt() - 1;
      long w = in.nextLong();
      adj.get(p).add(i);
      distanceToParent[i] = w;
    }

    visit(0);
    for (int i = 0; i < n; i++) {
      int total = 0;
      for (int child : adj.get(i)) {
        total += count[child];
      }
      out.print(total + " ");
    }
    out.println();
  }

  private void visit(int idx) {
    if (idx != 0 && distanceToParent[idx] <= radius[idx]) {
      // find the highest reachable parent
      int low = stackFirst;
      int high = stackLast;
      int ancestor = stack[high];
      while (low <= high) {
        int mid = low + (high - low)/2;
        int node = stack[mid];
        if (distance[idx] - distance[node] <= radius[idx]) {
          ancestor = node;
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      count[idx]++;
      count[ancestor]--;
    }
    stack[++stackLast] = idx;
    for (int child : adj.get(idx)) {
      distance[child] = distance[idx] + distanceToParent[child];
      visit(child);
      count[idx] += count[child];
    }
    stackLast--;
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
