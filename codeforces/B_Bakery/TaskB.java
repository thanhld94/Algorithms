import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class TaskB{
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    int k = input.nextInt();
    Edge[] edges = new Edge[m];
    for (int i = 0; i < m; i++) {
      int u = input.nextInt();
      int v = input.nextInt();
      int l = input.nextInt();
      edges[i] = new Edge(u,v,l);
    }

    boolean[] storage = new boolean[n + 1];
    for (int i = 0; i < k; i++) {
      int store = input.nextInt();
      storage[store] = true;
    }

    int result = Integer.MAX_VALUE;
    for (Edge edge : edges) {
      if ((storage[edge.u] && !storage[edge.v]) || (storage[edge.v] && !storage[edge.u])) {
        result = Math.min(result, edge.l);
      }
    }
    if (result < Integer.MAX_VALUE) {
      output.println(result);
    } else {
      output.println(-1);
    }
  }

  private class Edge {
    int u;
    int v;
    int l;

    private Edge(int u, int v,int l) {
      this.u = u;
      this.v = v;
      this.l = l;
    }
  }
}
