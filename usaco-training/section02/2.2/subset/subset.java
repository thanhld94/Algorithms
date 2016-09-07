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

    long[] dp = getDpFunction(n, total/2);
    output.println(dp[total/2]/ 2);
  }

  private long[] getDpFunction(int n, int value) {
    long[] f = new long[value + 1];
    f[0] = 1L;
    for (int key = 1; key <= n; key++) {
      for (int sum = value; sum >= key; sum--) {
        f[sum] += f[sum - key];
      }
    }
    return f;
  }
}
