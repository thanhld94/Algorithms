import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    int[][] a = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        a[i][j] = input.nextInt();
      }
    }

    if (valid(a, n, m)) {
      output.println("YES");
      return;
    }

    for (int c1 = 1; c1 < m; c1++) {
      for (int c2 = c1 + 1; c2 <= m; c2++) {
        swapRow(c1, c2, a);
        if (valid(a, n, m)) {
          output.println("YES");
          return;
        }
        swapRow(c1, c2, a);
      }
    }

    output.println("NO");
  }

  private void print(int[][] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = 1; j < a[0].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private boolean valid(int[][] a, int n, int m) {
    boolean check = true;
    for (int i = 1; i <= n; i++) {
      int count = 0;
      for (int j = 1; j <= m; j++) {
        if (a[i][j] != j) count++;
      }
      if (count > 2) check = false;
    }
    return check;
  }

  private void swapRow(int x, int y, int[][] a) {
    for (int i = 0; i < a.length; i++) {
      int tmp = a[i][x];
      a[i][x] = a[i][y];
      a[i][y] = tmp;
    }
  }
}
