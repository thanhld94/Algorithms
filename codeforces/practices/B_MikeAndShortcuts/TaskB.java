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
    int[] adj = new int[n];

    for (int i = 0; i < n; i++) {
      int dest = input.nextInt() - 1;
      adj[i] = dest;
    }

    int[] dist = new int[n];
    bfs(adj, dist);
    for (int d : dist) {
      output.print(d + " ");
    }
    output.println();
  }

  private void bfs(int[] adj, int[] d) {
    Queue <Integer> queue = new LinkedList<Integer>();
    queue.add(0);
    boolean[] visited = new boolean[adj.length];
    visited[0] = true;
    while (queue.size() != 0) {
      int node = queue.poll();
      for (int i = -1; i <= 1; i += 2) {
        int next = node + i;
        if (next < adj.length && next >= 0 && !visited[next]) {
          visited[next] = true;
          d[next] = d[node] + 1;
          queue.add(next);
        }
      }

      if (!visited[adj[node]]) {
        d[adj[node]] = d[node] + 1;
        visited[adj[node]] = true;
        queue.add(adj[node]);
      }
    }
  }
}
