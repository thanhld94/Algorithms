import java.util.*;

public class FromToDivisibleDiv2 {
  
  public int shortest(int N, int S, int T, int[] a, int[] b) {
    int M = a.length;
    Node[] nodes = new Node[N + M + 1];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new Node();
    }

    for (int p = 1; p <= N; p++) {
      for (int i = 0; i < M; i++) {
        if (p % a[i] == 0) {
          nodes[p].adj.add(N + i + 1);
        }
      }
    }

    for (int p = 1; p <= N; p++) {
      for (int i = 0; i < M; i++) {
        if (p % b[i] == 0) {
          nodes[N + i + 1].adj.add(p);
        }
      }
    }

    int result = bfs(S, T, nodes);
    return result;
  }

  private int bfs(int s, int t, Node[] nodes) {
    int[] d = new int[nodes.length];
    Arrays.fill(d, -1);
    d[s] = 0;
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    while (queue.size() > 0) {
      int u = queue.poll();
      for (int next : nodes[u].adj) {
        if (d[next] == -1) {
          d[next] = d[u] + 1;
          if (next == t) {
            return d[next] / 2;
          }
          queue.add(next);
        }
      }
    }
    return -1;
  }

  private class Node {
    private Set<Integer> adj;

    private Node() {
      adj = new HashSet<Integer>();
    }
  }
}
