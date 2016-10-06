import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PrintWriter output = new PrintWriter(System.out);
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int test = 0;
    int n = input.nextInt();
    while (n > 0) {
      int s = input.nextInt();
      int t = input.nextInt();
      int m = input.nextInt();
      Node[] nodes = new Node[n + 1];
      for (int i = 0; i <= n; i++) {
        nodes[i] = new Node();
      }

      for (int i = 0; i < m; i++) {
        int u = input.nextInt();
        int v = input.nextInt();
        int w = input.nextInt();
        if (nodes[u].adj.containsKey(v)) {
          nodes[u].adj.get(v).capacity += w;
        } else {
          nodes[u].adj.put(v, new Edge(w, 0));
        }

        if (nodes[v].adj.containsKey(u)) {
          nodes[v].adj.get(u).capacity += w;
        } else {
          nodes[v].adj.put(u, new Edge(w, 0));
        }
      }

      process(s, t, nodes, output, ++test);
      n = input.nextInt();
    }
  }

  private void process(int s, int t, Node[] nodes, PrintWriter output, int test) {
    int[] trace = new int[nodes.length];
    while (findpath(s, t, nodes, trace)) {
      incflow(s, t, nodes, trace);
    }
    int maxflow = 0;
    for (Entry<Integer, Edge> entry : nodes[t].adj.entrySet()) {
      int v = entry.getKey();
      int f = nodes[v].adj.get(t).flow;
      if (f > 0) {
        maxflow += f;
      }
    }
    System.out.printf("Network %d\n", test);
    System.out.printf("The bandwidth is %d.\n\n", maxflow);
  }

  private boolean findpath(int s, int t, Node[] nodes, int[] trace) {
    Arrays.fill(trace, -1);
    Queue<Integer> queue = new LinkedList<Integer>();
    trace[s] = nodes.length;
    queue.add(s);
    while (queue.size() > 0) {
      int u = queue.poll();
      if (u == t) {
        return true;
      }
      for (Entry<Integer, Edge> entry : nodes[u].adj.entrySet()) {
        int v = entry.getKey();
        Edge edge = entry.getValue();
        if (trace[v] == -1 && edge.capacity > edge.flow) {
          trace[v] = u;
          queue.add(v);
        }
      }
    }
    return false;
  }

  private void incflow(int s, int t, Node[] nodes, int[] trace) {
    int delta = Integer.MAX_VALUE;
    int v = t;
    while (v != s) {
      int u = trace[v];
      delta = Math.min(delta, nodes[u].adj.get(v).capacity - nodes[u].adj.get(v).flow);
      v = u;
    }

    v = t;
    while (v != s) {
      int u = trace[v];
      nodes[u].adj.get(v).flow += delta;
      nodes[v].adj.get(u).flow -= delta;
      v = u;
    }
  }

  private class Node {
    Map<Integer, Edge> adj;

    private Node() {
      adj = new HashMap<Integer, Edge>();
    }
  }

  private class Edge {
    private int capacity;
    private int flow;

    private Edge(int capacity, int flow) {
      this.capacity = capacity;
      this.flow = flow;
    }
  }
}
