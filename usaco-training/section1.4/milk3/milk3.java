/*
ID: thanhld1
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;

public class milk3 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("milk3.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
    milk3 sol = new milk3();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    boolean[][][] visited = new boolean[a + 1][b + 1][c + 1];
    int[] initialState = {0, 0, c};
    int[] cap = {a, b, c};
    Node first = new Node(initialState);
    visit(first, visited, cap);
    boolean firstResult = true;
    for (int stateC = 0; stateC <= c; stateC++) {
      boolean found = false;
      for (int stateB = 0; stateB <= b; stateB++) {
        if (visited[0][stateB][stateC]) {
          found = true;
          break;
        }
      }
      if (found) {
        if (firstResult) {
          output.print(stateC);
          firstResult = false;
        } else {
          output.print(" " + stateC);
        }
      }
    }
    output.println();
  }

  private void visit(Node p, boolean[][][] visited, int[] cap) {
    visited[p.amounts[0]][p.amounts[1]][p.amounts[2]] = true;
    for (int source = 0; source < 3; source++) {
      for (int dest = 0; dest < 3; dest++) {
        if (source != dest) {
          Node next = getNext(p, source, dest, cap);
          if (!visited[next.amounts[0]][next.amounts[1]][next.amounts[2]]) {
            visit(next, visited, cap);
          }
        }
      }
    }
  }

  private Node getNext(Node p, int source, int dest, int[] cap) {
    int[] next = new int[3];
    for (int i = 0; i < 3; i++) {
      next[i] = p.amounts[i];
    }

    next[dest] = Math.min(p.amounts[source] + p.amounts[dest], cap[dest]);
    next[source] = (p.amounts[source] + p.amounts[dest] > cap[dest]) ? p.amounts[source] + p.amounts[dest] - cap[dest] : 0;
    return new Node(next);
  }

  private class Node {
    private int[] amounts;
    
    private Node(int[] am) {
      amounts = new int[3];
      amounts[0] = am[0];
      amounts[1] = am[1];
      amounts[2] = am[2];
    }
  }
}
