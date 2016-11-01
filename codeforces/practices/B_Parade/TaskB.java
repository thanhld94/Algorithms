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
    int n = input.nextInt();
    int[] l = new int[n];
    int[] r = new int[n];
    int L = 0;
    int R = 0;
    int result = -1;
    for (int i = 0; i < n; i++) {
      l[i] = input.nextInt();
      r[i] = input.nextInt();
      L += l[i];
      R += r[i];
    }
    result = Math.abs(L - R);
    int idx = -1;

    for (int i = 0; i < n; i++) {
      int nL = L - l[i] + r[i];
      int nR = R - r[i] + l[i];
      if (result < Math.abs(nL - nR)) {
        result = Math.abs(nL - nR);
        idx = i;
      }
    }
    output.println(idx + 1);
  }
}
