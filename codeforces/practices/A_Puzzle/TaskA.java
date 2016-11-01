import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    ta.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int m = input.nextInt();
    int n = input.nextInt();
    int[] pieces = new int[n];
    for (int i = 0; i < n; i++) {
      pieces[i] = input.nextInt();
    }
    Arrays.sort(pieces);
    int idx = 0;
    int result = Integer.MAX_VALUE;
    while (idx <= n - m) {
      result = Math.min(result, pieces[idx + m - 1] - pieces[idx]);
      idx++;
    }
    output.println(result);
  }
}
