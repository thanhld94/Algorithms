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
    Node[] nodes = new Node[38];

    while (true) {
      for (int i = 0; i < nodes.length; i++) {
        nodes[i] = new Node();
      }

      String line = input.nextLine();
      int totalApps = 0;
      while (line.length() > 0) {
        int app = line.charAt(0) - 'A' + 1;
        int cap = line.charAt(1) - '0';
        totalApps += cap;

        // connecting to source
        nodes[0].adj.put(app, new Edge(cap, 0));
        nodes[app].adj.put(0, new Edge(0, 0));

        // connecting apps with computers
        for (int i = 3; i < line.length(); i++) {
          if (line.charAt(i) == ';') break;
          int comp = line.charAt(i) - '0' + 27;
          nodes[app].adj.put(comp, new Edge(1, 0));
          nodes[comp].adj.put(app, new Edge(0, 0));
        }
        if (!input.hasNext()) {
          break;
        }
        line = input.nextLine();
      }
        // connecting to sink
      for (int comp = 27; comp < 37; comp++) {
        nodes[comp].adj.put(37, new Edge(1, 0));
        nodes[37].adj.put(comp, new Edge(0, 0));
      }
      process(nodes, totalApps, output);
      if (!input.hasNext()) {
        return;
      }
    }
  }

  private void process(Node[] nodes, int totalApps, PrintWriter output) {
    int s = 0;
    int t = 37;
    int n = nodes.length;
    int[] trace = new int[n];
    while (findpath(s, t, nodes, trace)) {
      incflow(s, t, nodes, trace);
    }

    int maxflow = 0;
    for (int comp = 27; comp < 37; comp++) {
      maxflow += nodes[comp].adj.get(37).flow;
    }
    if (maxflow < totalApps) {
      output.println("!");
      return;
    }

    String result = "";
    for (int comp = 27; comp < 37; comp++) {
      char letter = '_';
      for (int app = 1; app <= 26; app++) {
        if (nodes[app].adj.containsKey(comp) && nodes[app].adj.get(comp).flow > 0) {
          letter = (char)(app + 'A' - 1);
          break;
        }
      }
      result += letter;
    }
    output.println(result);
  }

  private boolean findpath(int s, int t, Node[] nodes, int[] trace) {
    Arrays.fill(trace, -1);
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    trace[s] = nodes.length;
    while (queue.size() > 0) {
      int u = queue.poll();
      if (u == t) return true;
      for (Entry<Integer, Edge> edge : nodes[u].adj.entrySet()) {
        int v = edge.getKey();
        Edge w = edge.getValue();
        if (trace[v] == -1 && w.capacity > w.flow) {
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
      Edge w = nodes[u].adj.get(v);
      delta = Math.min(delta, w.capacity - w.flow);
      v = u;
    }

    v = t;
    while (v != s) {
      int u = trace[v];
      Edge w = nodes[u].adj.get(v);
      w.flow += delta;

      Edge wrev = nodes[v].adj.get(u);
      wrev.flow -= delta;
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
    int capacity;
    int flow;

    private Edge(int capacity, int flow) {
      this.capacity = capacity;
      this.flow = flow;
    }
  }
}
