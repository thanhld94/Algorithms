/*
ID: thanhld1
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;

public class numtri {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("numtri.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
    numtri sol = new numtri();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());

    int[][] board = new int[n + 1][n + 1];
    for (int row = 1; row <= n; row++) {
      st = new StringTokenizer(input.readLine());
      for (int col = 1; col <= row; col++) {
        board[row][col] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] maxSum = new int[n + 1][n + 1];
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) {
        maxSum[row][col] = Math.max(maxSum[row - 1][col - 1], maxSum[row - 1][col]) + board[row][col];
      }
    }

    int result = -1;
    for (int entry : maxSum[n]) {
      result = Math.max(result, entry);
    }
    output.println(result);
  }
}
