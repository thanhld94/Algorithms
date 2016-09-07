/*
ID: thanhld1
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.*;

public class subset {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("subset.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
    subset sol = new subset();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int total = n * (n + 1) / 2;
    if (total % 2 == 1) {
      output.println(0);
      return;
    }

    int[][] dp = getDpFunction(n, total/2);
    long result = 0L;
    for (int i = 1; i <= n; i++) {
      result += dp[total / 2][i];
    }
    output.println(result / 2);
  }

  private int[][] getDpFunction(int n, int value) {
    int[][] f = new int[value + 1][n + 1];
    f[0][0] = 1;
    for (int sum = 1; sum <= value; sum++) {
      for (int key = 1; key <= n; key++) {
        if (key <= sum) {
          for (int subkey = 0; subkey < key; subkey++) {
            f[sum][key] += f[sum - key][subkey];
          }
        }
      }
    }
    return f;
  }
}
