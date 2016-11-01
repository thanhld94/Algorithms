import java.io.PrintWriter;
import java.util.Scanner;

public class TaskD {
  private static final long BASE = 1000000007L;
  private static final int MAXN = 100001;

  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int q = input.nextInt();
    int k = input.nextInt();

    long[] dp = getDp(k);
    long[] sum = new long[MAXN];
    for (int i = 1; i < sum.length; i++) {
      sum[i] = (sum[i - 1] + dp[i]) % BASE;
    }

    for (int i = 1; i <= q; i++) {
      int a = input.nextInt();
      int b = input.nextInt();
      long result = (sum[b] - sum[a - 1] + BASE) % BASE;
      output.println(result);
    }
  }

  private long[] getDp(int k) {
    long[] f = new long[MAXN];
    f[0] = 1L;
    for (int i = 1; i < MAXN; i++) {
      f[i] = f[i - 1];
      if (i - k >= 0) {
        f[i] += f[i - k];
      }
      f[i] %= BASE;
    }
    return f;
  }
}
