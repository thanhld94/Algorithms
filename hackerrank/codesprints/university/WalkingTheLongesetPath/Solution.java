import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Solution sol = new Solution();
    sol.solve(in, out);
    out.close();
  }
  
  Node[] nodes;
  int n, m;
  boolean[] visited;
  
  private void solve(Scanner in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    nodes = new Node[n];
    for (int i = 0; i < n; i++) nodes[i] = new Node();
    for (int i = 0; i < m; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      nodes[u].adj.add(v);
      nodes[u].deg++;
      nodes[v].adj.add(u);
      nodes[v].deg++;
    }
    
    int begin = 0;
    for (int i = 0; i < n; i++) 
      if (nodes[i].deg < nodes[begin].deg) 
        begin = i;
    visited = new boolean[n];
    List<Integer> result = new ArrayList<Integer>();
    process(begin, result);
    if (result.size() < n) {
      Collections.reverse(result);
      process(begin, result);
    }
    out.println(result.size());
    for (int node : result) {
      out.print(node + " ");
    }
    out.println();
  }
  
  private void process(int idx, List<Integer> result) {
    if (!visited[idx]) {
      result.add(idx + 1);
      visited[idx] = true;
    }
    int next = -1;
    int min = Integer.MAX_VALUE;
    for (int node : nodes[idx].adj) {
      if (!visited[node]) {
        nodes[node].deg--;
        if (nodes[node].deg < min) {
          min = nodes[node].deg;
          next = node;
        }
      }
    }
    if (next != -1) 
      process(next, result);
  }
  
  private class Node {
    Set<Integer> adj;
    int deg;
    
    private Node() {
      deg = 0;
      adj = new HashSet<Integer>();
    }
  }
}