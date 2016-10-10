import java.util.*;

public class SubtreeSum {
  private static final long MODULE = (long)1e9+7; 

  public int getSum(int[] p, int[] x) {
    int n = p.length + 1;
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node();
      nodes[i].weight = x[i];
    }

    for (int i = 0; i < p.length; i++) {
      nodes[p[i]].adj.add(i + 1);
      nodes[i + 1].adj.add(p[i]);
    }

    long[] ntotal = new long[n];
    Arrays.fill(ntotal, -1);

    long result = 0L;
    for (int i = 0; i < 32; i++) {
      long[] count = new long[n];
      Arrays.fill(count, -1);
      for (int idx = 0; idx < n; idx++) {
        result = (result + ((1 << i) * (countTotal(nodes, idx, ntotal) + MODULE - countZeroAt(i, nodes, idx, count)% MODULE)) % MODULE) % MODULE; 
      }
    }
    return (int)result;
  }

  private long countTotal(Node[] nodes, int idx, long[] ntotal) {
    if (ntotal[idx] != -1) {
      return ntotal[idx];
    }
    if (nodes[idx].parent != -1 && nodes[idx].adj.size() == 1) {
      ntotal[idx] = 1L;
      return 1L;
    }

    long result = 1L;
    for (int next : nodes[idx].adj) {
      if (next != nodes[idx].parent) {
        nodes[next].parent = idx;
        result = (result * (countTotal(nodes, next, ntotal) + 1)) % MODULE;
      }
    }
    ntotal[idx] = result;
    return ntotal[idx];
  }

  private long countZeroAt(int bit, Node[] nodes, int idx, long[] count) {
    if (count[idx] != -1) {
      return count[idx];
    }

    if ((nodes[idx].weight & (1 << bit)) != 0) {
      count[idx] = 0L;
      return 0L;
    }

    if (nodes[idx].parent != -1 && nodes[idx].adj.size() == 1) {
      count[idx] = 1L;
      return count[idx];
    }

    long result = 1L;
    for (int next : nodes[idx].adj) {
      if (next != nodes[idx].parent) {
        result = (result * (countZeroAt(bit, nodes, next, count) + 1)) % MODULE;
      } 
    }

    count[idx] = result;
    return count[idx];
  }
  
  private class Node {
    private int parent;
    private int weight;
    private Set<Integer> adj;

    private Node() {
      adj = new HashSet<Integer>();
      parent = -1;
    }
  }
}
