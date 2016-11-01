import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskD{
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < n; i++) {
      t[i] = input.nextInt();
    }
    Arrays.sort(t);

    int result = 1;
    long sum = t[0];
    for (int i = 1; i < n; i++) {
      if (t[i] >= sum) {
        sum += t[i];
        result++;
      }
    }
    output.println(result);
  }
}
