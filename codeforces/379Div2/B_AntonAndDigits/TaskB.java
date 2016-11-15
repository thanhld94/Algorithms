import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int k2 = input.nextInt();
    int k3 = input.nextInt();
    int k5 = input.nextInt();
    int k6 = input.nextInt();

    int sum1 = 0;
    {
      int n256 = Math.min(k2, Math.min(k5, k6));
      sum1 += 256 * n256;
      int newK2 = k2 - n256;
      sum1 += 32 * Math.min(newK2, k3);
    }

    int sum2 = 0;
    {
      int n32 = Math.min(k2, k3);
      sum2 += 32 * n32;
      int newK2 = k2 - n32;
      sum2 += 256 * Math.min(newK2, Math.min(k5, k6));
    }
    output.println(Math.max(sum1, sum2));
  }
}
