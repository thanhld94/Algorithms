import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    ta.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int[] nums = new int[4];
    for (int i = 0; i < 4; i++) {
      nums[i] = input.nextInt();
    }
    int n = input.nextInt();
    boolean[] visited = new boolean[n + 1];
    for (int num : nums) {
      for (int i = num; i <= n; i += num) {
        visited[i] = true;
      }
    }

    int result = 0;
    for (boolean visit : visited) {
      if (visit) {
        result++;
      }
    }
    output.println(result);
  }
}
