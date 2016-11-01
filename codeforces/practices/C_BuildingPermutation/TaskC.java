import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    Arrays.sort(a);
    long result = 0;
    for (int i = 1; i <= n; i++) {
      result += Math.abs(a[i - 1] - i);
    }
    output.println(result);
  }
}
