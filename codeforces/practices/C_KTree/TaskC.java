import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  private static final int BASE = 1000000007;

  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int k = input.nextInt();
    int d = input.nextInt();
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j] = -1;
      }
    }
    int result = generate(n, k, d, 0, dp);
    output.println(result);
  }

  private int generate(int n, int k, int d, int currentMax, int[][] f) {
    if (f[n][currentMax] != -1) {
      return f[n][currentMax];
    }

    if (n < d && currentMax < d) {
      f[n][currentMax] = 0; 
      return 0;
    }

    if (n == 0) {
      f[n][currentMax] = 1;
      return 1;
    }
  
    int count = 0;
    for (int i = 1; i <= k; i++) {
      if (i <= n) {
        count += generate(n - i, k, d, Math.max(i, currentMax), f);
        count %= BASE;
      }
    }
    f[n][currentMax] = count;
    return f[n][currentMax];
  }
}
