import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PrintWriter output = new PrintWriter(System.out);
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int nk = input.nextInt();
    int np = input.nextInt();
    while (nk != 0 && np != 0) {
      Node[] nodes = new Node[np + nk + 2];
      int s = 0;
      int t = np + nk + 1;
      for (int i = 0; i < nodes.length; i++) {
        nodes[i] = new Node();
      }

      int total = 0;
      for (int category = 1; category <= nk; category++) {
        int w = input.nextInt();
        total += w;
        nodes[s].add(category, w);
        nodes[category].add(s, 0);
      }

      for (int i = 1; i <= np; i++) {
        int prob = nk + i;
        int num = input.nextInt();
        for (int j = 0; j < num; j++) {
          int category = input.nextInt();
          nodes[category].add(prob, 1);
          nodes[prob].add(category, 0);
        }
      }

      for (int prob = nk + 1; prob <= nk + np; prob++) {
        nodes[prob].add(t, 1);
        nodes[t].add(prob, 0);
      }
      process(s, t, nodes, nk, np, total, output);

      nk = input.nextInt();
      np = input.nextInt();
    }
  }

  private void process(int s, int t, Node[] nodes, int nk, int np, int total, PrintWriter output) {
    int[] trace = new int[nodes.length];
    while (findpath(s, t, nodes, trace)) {
      incflow(s, t, nodes, trace);
    }

    int maxflow = 0;
    for (int prob = nk + 1; prob <= nk + np; prob++) {
      if (nodes[prob].getFlow(t) > 0) {
        maxflow += nodes[prob].getFlow(t);
      }
    }
    if (maxflow != total) {
      output.println(0);
      return;
    }

    output.println(1);
    for (int category = 1; category <= nk; category++) {
      boolean first = true;
      for (int prob = 1; prob <= np; prob++) {
        if (nodes[category].getFlow(prob + nk) > 0) {
          if (first) {
            first = false;
            output.print(prob);
          } else {
            output.print(" " + prob);
          }
        }
      }
      output.println();
    }
  }

  private boolean findpath(int s, int t, Node[] nodes, int[] trace) {
    Arrays.fill(trace, -1);
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    trace[s] = nodes.length;
    while (queue.size() > 0) {
      int u = queue.poll();
      if (u == t) {
        return true;
      }
      for (Map.Entry<Integer, Edge> entry : nodes[u].adj.entrySet()) {
        int v = entry.getKey();
        if (trace[v] == -1 && nodes[u].getCapacity(v) > nodes[u].getFlow(v)) {
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
      delta = Math.min(delta, nodes[u].getCapacity(v) - nodes[u].getFlow(v));
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
    private Map<Integer, Edge> adj;

    private Node() {
      adj = new HashMap<Integer, Edge>();
    }

    private void add(int next, int capacity) {
      adj.put(next, new Edge(capacity, 0));
    }

    private int getFlow(int next) {
      if (!adj.containsKey(next)) {
        return 0;
      }
      return adj.get(next).flow;
    }

    private int getCapacity(int next) {
      if (!adj.containsKey(next)) {
        return 0;
      }
      return adj.get(next).capacity;
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
