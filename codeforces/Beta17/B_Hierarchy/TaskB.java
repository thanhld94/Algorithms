import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] q = new int[n];
    for (int i = 0; i < n; i++) {
      q[i] = input.nextInt();
    }

    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node();
    }

    int m = input.nextInt();
    for (int i = 0; i < m; i++) {
      int a = input.nextInt() - 1;
      int b = input.nextInt() - 1;
      int c = input.nextInt();
      if (q[a] > q[b]) {
        nodes[b].add(a, c);
      }
    }

    int[] cost = new int[n];
    boolean[] used = new boolean[n];
    Arrays.fill(cost, Integer.MAX_VALUE);

    int count = 0;
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (nodes[i].adj.size() == 0) {
        if (count > 0) {
          output.println(-1);
          return;
        }
        count++;
        continue;
      }
      int min = Integer.MAX_VALUE;
      for (Map.Entry<Integer, Integer> edge : nodes[i].adj.entrySet()) {
        min = Math.min(min, edge.getValue());
      }
      result += min;
    }
    output.println(result);
  }

  private class Node {
    private Map<Integer, Integer> adj;

    private Node() {
      adj = new HashMap<Integer, Integer>();
    }

    private void add(int v, int w) {
      if (adj.containsKey(v)) {
        adj.put(v, Math.min(adj.get(v), w));
      } else {
        adj.put(v, w);
      }
    }
  }
}
