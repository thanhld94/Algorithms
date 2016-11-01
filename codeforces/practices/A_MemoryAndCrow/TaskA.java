import java.io.PrintWriter;
import java.util.*;

public class TaskA {
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    for (int i = 0; i < n; i++) {
      int b = (i < n - 1) ? a[i] + a[i + 1] : a[i];
      output.print(b + " ");
    }
    output.println();
  }
}
