import java.io.PrintWriter;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  private int[] days;
  private int[] exams;
  private int n, m;

  public void solve(Scanner input, PrintWriter output) {
    n = input.nextInt();
    m = input.nextInt();
    days = new int[n];
    for (int i = 0; i < n; i++) {
      days[i] = input.nextInt();
    }
    exams = new int[m];
    for (int i = 0; i < m; i++) {
      exams[i] = input.nextInt(); 
    }
    Arrays.sort(exams);
    solve(output);
  }

  private void solve(PrintWriter output) {
    int left = 0;
    int right = n - 1;
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (check(mid)) {
        right = mid - 1;
        result = mid;
      } else {
        left = mid + 1;
      }
    }
    if (result != -1) result++;
    output.println(result);
  }

  private boolean check(int range) {
    int[] finish = new int[m];
    int[] needs = new int[n];
    for (int i = range; i >= 0; i--) {
      if (days[i] > 0) {
        int subject = days[i] - 1;
        finish[subject] = Math.max(finish[subject], i);
      }
    }
    for (int i = 0; i < m; i++) {
      needs[finish[i]] = exams[i];
    }

    long total = 0;
    for (int i = 0; i < n; i++) {
      total += needs[i];
      if (needs[i] > 0) total++;
      if (total > i + 1) return false;
    }
    return true;
  }
}
