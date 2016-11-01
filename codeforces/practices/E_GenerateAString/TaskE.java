import java.io.PrintWriter;
import java.util.Scanner;

public class TaskE{
  public static void main(String[] args) {
    TaskE tE = new TaskE();
    PrintWriter pw = new PrintWriter(System.out);
    tE.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int x = input.nextInt();
    int y = input.nextInt();

    long [] f = new long[n + 1];
    f[1] = x;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + x;
      if (i % 2 == 0) {
        f[i] = Math.min(f[i], f[i / 2] + y);
      } else {
        f[i] = Math.min(f[i], f[(i + 1) / 2] + y + x);
      }
    }
    output.println(f[n]);
  }
}
