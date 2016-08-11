import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
  public static void main(String[] args) {
    TaskB tb = new TaskB();
    tb.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] parties = new int[n];
    for (int i = 0; i < n; i++) {
      parties[i] = input.nextInt();
    }
    Arrays.sort(parties);
    int result = 0;
    int l = 0;
    int r = parties.length - 1;
    int count = 0;
    while (count < n) {
      if (l >= r) {
        count++;
        result++;
        l++;
      } else if (parties[l] + parties[r] <= 4) {
        int current = parties[l] + parties[r];
        result++;
        l++;
        r--;
        count += 2;
        while (l < n && parties[l] + current <= 4) {
          current += parties[l];
          l++;
          count++;
        }
      } else {
        count++;
        result++;
        r--;
      }
    }
    output.println(result);
    output.close();
  }
}
