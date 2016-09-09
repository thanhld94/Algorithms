import java.io.*;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    String[] first = new String[n];
    String[] last = new String[n];
    for (int i = 0; i < n; i++) {
      first[i] = input.next();
      last[i] = input.next();
    }

    int[] order = new int[n];
    for (int i = 0; i < n; i++) {
      order[i] = input.nextInt() - 1;
    }

    reorder(first, last, order);

    boolean[] visited = new boolean[2 * n];
    dfs(0, first, last, visited);
    dfs(n, first, last, visited);
    if (visited[n - 1] || visited[2 * n - 1]) {
      output.println("YES");
    } else {
      output.println("NO");
    }
  }

  private void reorder(String[] first, String[] last, int[] order) {
    String[] tmpFirst = new String[first.length];
    String[] tmpLast = new String[last.length];
    for (int i = 0; i < order.length; i++) {
      tmpFirst[i] = first[order[i]];
      tmpLast[i] = last[order[i]];
    }
    for (int i = 0; i < first.length; i++) {
      first[i] = tmpFirst[i];
      last[i] = tmpLast[i];
    }
  }

  private void dfs(int current, String[] first, String[] last, boolean[] visited) {
    visited[current] = true;
    int idx = (current < first.length) ? current : current - first.length;
    if (idx + 1 == first.length) {
      return;
    }
    
    String currentString = (current < first.length) ? first[idx] : last[idx];
    if (currentString.compareTo(first[idx + 1]) < 0) {
      int next = idx + 1;
      if (!visited[next]) 
        dfs(next, first, last, visited);
    }
    if (currentString.compareTo(last[idx + 1]) < 0) {
      int next = idx + 1 + first.length;
      if (!visited[next]) 
        dfs(next, first, last, visited);
    }
  }
}
