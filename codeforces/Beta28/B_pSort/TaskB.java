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
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      int p = input.nextInt() - 1;
      nodes[i] = new Node(p);
    }

    for (int i = 0; i < n; i++) {
      int d = input.nextInt();
      int left = i - d;
      if (left >= 0) {
        nodes[i].adj.add(left);
        nodes[left].adj.add(i);
      }

      int right = i + d;
      if (right < n) {
        nodes[i].adj.add(right);
        nodes[right].adj.add(i);
      }
    }

    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(visited, false);
      if (!search(i, nodes, i, visited)) {
        output.println("NO");
        return;
      }
    }
    output.println("YES");
  }

  private boolean search(int idx, Node[] nodes, int target, boolean[] visited) {
    if (nodes[idx].val == target) {
      return true;
    }
    if (visited[idx]) return false;

    visited[idx] = true;
    for (int next : nodes[idx].adj) {
      if (search(next, nodes, target, visited)) {
        return true;
      }
    }
    return false;
  }

  private class Node {
    private int val;
    private Set<Integer> adj;

    private Node(int val) {
      this.val = val;
      adj = new HashSet<Integer>();
    }
  }
}
