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
    String dir = input.next();

    int[] pos = new int[n];
    for (int i = 0; i < n; i++) {
      pos[i] = input.nextInt();
    }

    int result = -1;
    for (int i = 1; i < n; i++) {
      if (dir.charAt(i) == 'L' && dir.charAt(i - 1) == 'R') {
        int dist = (pos[i] - pos[i - 1]) / 2;
        result = (result == -1) ? dist : Math.min(dist, result);
      }
    }
    output.println(result);
  }
}
