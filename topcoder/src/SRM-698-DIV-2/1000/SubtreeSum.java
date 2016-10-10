import java.util.*;

public class SubtreeSum {
  
  private static final long MODULE = (long) 1e9+7;

  public int getSum(int[] p, int[] x) {
    Node[] nodes = new Node[p.length + 1];
    int n = nodes.length;
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(x[i]);
    }

    for (int i = 0; i < p.length; i++) {
      nodes[p[i]].adj.add(i + 1);
      nodes[i + 1].adj.add(p[i]);
    }

    long[] totalTree = new long[n];
    Arrays.fill(totalTree, -1);

    long result = 0L;
    for (int bit = 0; bit < 32; bit++) {
      long[] badTree = new long[n];
      Arrays.fill(badTree, -1);
      for (int idx = 0; idx < n; idx++) {
        long count = (countTotal(idx, nodes, totalTree) + MODULE - countBad(bit, idx, nodes, badTree)) % MODULE;
        result = (result + ((count * (1 << bit)) % MODULE)) % MODULE;
      }
    }
    return (int) result;
  }

  private long countTotal(int idx, Node[] nodes, long[] totalTree) {
    if (totalTree[idx] != -1) {
      return totalTree[idx];
    }

    if (nodes[idx].parent != -1 && nodes[idx].adj.size() == 1) { // leaf
      totalTree[idx] = 1L;
      return totalTree[idx];
    }

    long result = 1L;
    for (int next : nodes[idx].adj) {
      if (next != nodes[idx].parent) {
        nodes[next].parent = idx;
        result = (result * (countTotal(next, nodes, totalTree) + 1)) % MODULE;
      }
    }
    totalTree[idx] = result;
    return totalTree[idx];
  }

  private long countBad(int bit, int idx, Node[] nodes, long[] badTree) {
    if (badTree[idx] != -1) {
      return badTree[idx];
    }

    if ((nodes[idx].weight & (1 << bit)) != 0) { // good subtree
      badTree[idx] = 0L;
      return badTree[idx];
    }
    
    if (nodes[idx].parent != -1 && nodes[idx].adj.size() == 1) { // leaf
      badTree[idx] = 1L;
      return badTree[idx];
    }

    long result = 1L;
    for (int next : nodes[idx].adj) {
      if (next != nodes[idx].parent) {
        result = (result * (countBad(bit, next, nodes, badTree) + 1)) % MODULE;
      }
    }
    badTree[idx] = result;
    return result;
  }

  private class Node { 
    private int weight;
    private int parent;
    private Set<Integer> adj;

    private Node(int weight) {
      this.weight = weight;
      this.parent = -1;
      adj = new HashSet<Integer>();
    }
  }
}
