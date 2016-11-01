import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB{
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = input.nextInt();
    }
    Arrays.sort(x);
    int result = n / 2;
    if (n % 2 == 0) {
      result--;
    }
    output.println(x[result]);
  }
}
