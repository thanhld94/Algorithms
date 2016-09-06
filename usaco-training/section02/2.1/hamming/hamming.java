/*
ID: thanhld1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("hamming.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
    hamming sol = new hamming();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int numberOfNodes = (1 << b);
    boolean[] used = new boolean[numberOfNodes];

    if (!dfs(used, 0, n, d)) {
      System.out.println("not found");
    }
    
    int count = 0;
    for (int i = 0; i < numberOfNodes; i++) {
      if (used[i]) {
        count++;
        output.print(i);
        if (count % 10 == 0 || count == n) {
          output.println();
        } else {
          output.print(" ");
        }
      }
    }
  }

  private boolean dfs(boolean[] used, int depth, int n, int d) {
    if (depth == n) {
      return true;
    }

    for (int next = 0; next < used.length; next++) {
      if (!used[next]) {
        boolean check = true;
        for (int other = 0; other < used.length; other++) {
          if (used[other] && hammingDistance(next, other) < d) {
            check = false;
            break;
          }
        }

        if (check) {
          used[next] = true;
          if (dfs(used, depth + 1, n, d)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if (((1 << i) & xor) != 0) {
        count++;
      }
    }
    return count;
  }
}
