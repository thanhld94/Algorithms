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
    int n = input.nextInt();
    int test = 0;
    while (n != 0) {
      int m = input.nextInt();
      List<Pair> intervals = new ArrayList<Pair>();
      List<Integer> points = new ArrayList<Integer>();
      int[] amount = new int[n];
      int total = 0;
      for (int i = 0; i < n; i++) {
        amount[i] = input.nextInt();
        total += amount[i];
        int a = input.nextInt();
        int b = input.nextInt();
        intervals.add(new Pair(a,b));
        points.add(a);
        points.add(b);
      }
      Map<Integer, Integer> compressed = getCompress(points);
      Map<Integer, Integer> revMap = reverseMap(compressed);
      Node nodes[] = new Node[n + compressed.size() + 22];
      for (int i = 0; i < nodes.length; i++) {
        nodes[i] = new Node();
      }
      int s = nodes.length - 1;
      int t = nodes.length - 2;
      for (int i = 0; i < n; i++) {
        nodes[s].add(i, amount[i]);
        nodes[i].add(s, 0);
      }

      for (int i = 0; i < n; i++) {
        int idxa = compressed.get(intervals.get(i).first);
        int idxb = compressed.get(intervals.get(i).second);
        for (int j = idxa; j < idxb; j++) {
          nodes[i].add(j + n, m * (revMap.get(j + 1) - revMap.get(j)));
          nodes[j + n].add(i, 0);
        }
      }

      for (int i = 0; i < compressed.size() - 1; i++) {
        int w = revMap.get(i + 1) - revMap.get(i);
        nodes[n + i].add(t, w * m);
        nodes[t].add(n + i, 0);
      }
      process(s, t, nodes, total, n, ++test, compressed, revMap, output);
      n = input.nextInt();
    }
  }

  private void process(int s, int t, Node[] nodes, int total, int nleft, int test,
                            Map<Integer, Integer> compressed, Map<Integer, Integer> revMap, PrintWriter output) {
    int[] trace = new int[nodes.length];
    while (findpath(s, t, nodes, trace)) {
      incflow(s, t, nodes, trace);
    }
    int maxflow = 0;
    for (int i = nleft; i < nleft + compressed.size(); i++) {
      if (nodes[i].getFlow(t) > 0) {
        maxflow += nodes[i].getFlow(t);
      }
    }
    
    if (maxflow != total) {
      output.printf("Case %d: No\n", test);
      return;
    }
    output.printf("Case %d: Yes\n", test);
    for (int i = 0; i < nleft; i++) {
      List<Integer> list = new ArrayList<Integer>();
      for (int j = 0; j < compressed.size() - 1; j++) {
        if (nodes[i].getFlow(j + nleft) > 0) {
          list.add(revMap.get(j));
          int next = j + 1;
          while (next < compressed.size() - 1 && nodes[i].getFlow(next + nleft) > 0) {
            next++;
          }
          list.add(revMap.get(next));
          j = next;
        }
      }
      output.print(list.size() / 2 + " ");
      for (int j = 0; j < list.size(); j += 2) {
        output.printf("(%d, %d)", list.get(j), list.get(j + 1));
        if (j + 1 < list.size() - 1) {
          output.print(" ");
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

  private Map<Integer, Integer> getCompress(List<Integer> list) {
    Collections.sort(list);
    int count = 0;
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    result.put(list.get(0), 0);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) == list.get(i - 1)) {
        continue;
      }
      result.put(list.get(i), ++count);
    }
    return result;
  }

  private Map<Integer, Integer> reverseMap(Map<Integer, Integer> map) {
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      result.put(entry.getValue(), entry.getKey());
    }
    return result;
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
    private int flow;
    private int capacity;

    private Edge(int capacity, int flow) {
      this.capacity = capacity;
      this.flow = flow;
    }
  }

  private class Pair {
    private int first;
    private int second;

    private Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
