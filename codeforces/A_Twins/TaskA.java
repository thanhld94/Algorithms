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
    int n = input.nextInt();
    int[] coins = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      coins[i] = input.nextInt();
      sum += coins[i];
    }
    Arrays.sort(coins);
    int result = 0;
    for (int i = n - 1; i >= 0; i--) {
      result += coins[i];
      if (result > sum/2) {
        output.println(n - i);
        return;
      }
    }
  }
}
