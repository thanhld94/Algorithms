import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      int hasCat = input.nextInt();
      nodes[i] = new Node(hasCat == 1);
    }

    for (int i = 0; i < n - 1; i++) {
      int u = input.nextInt() - 1;
      int v = input.nextInt() - 1;
      nodes[u].adj.add(v);
      nodes[v].adj.add(u);
    }

    buildTree(nodes, 0);
    int result = dfs(nodes, 0, 0, m);
    output.println(result);
  }

  private void buildTree(Node[] nodes, int idx) {
    if (nodes.length == 0) {
      return;
    }
    nodes[idx].visited = true;
    for (Integer node : nodes[idx].adj) {
      if (!nodes[node].visited) {
        nodes[idx].treeAdj.add(node);
        buildTree(nodes, node);
      }
    }
  }

  private int dfs(Node[] nodes, int idx, int currentCount, int limit) {
    if (nodes.length == 0) {
      return 0;
    }
    int count = currentCount;
    if (nodes[idx].hasCat) {
      count++;
    } else {
      count = 0;
    }
    if (count > limit) {
      return 0;
    }
    
    if (nodes[idx].treeAdj.size() == 0) { // leaf
      return 1;
    } 
    // not leaf
    int result = 0;
    for (Integer node : nodes[idx].treeAdj) {
      result += dfs(nodes, node, count, limit);
    }
    return result;
  }

  private class Node {
    private List<Integer> adj;
    private List<Integer> treeAdj;
    private boolean hasCat;
    private boolean visited;

    private Node(boolean cat) {
      hasCat = cat;
      visited = false;
      adj = new ArrayList<Integer>();
      treeAdj = new ArrayList<Integer>();
    }
  }
}
