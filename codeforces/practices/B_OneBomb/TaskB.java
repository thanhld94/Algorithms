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

    int[] row = new int[n];
    int[] col = new int[m];
    boolean[][] wall = new boolean[n][m];
    int total = 0;
    for (int i = 0; i < n; i++) {
      String line = input.next();
      for (int j = 0; j < m; j++) {
        if (line.charAt(j) == '*') {
          wall[i][j] = true;
          row[i]++;
          col[j]++;
          total++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int check = (wall[i][j]) ? 1 : 0;
        if (row[i] + col[j] - check == total) {
          output.println("YES");
          output.println((i + 1) + " " + (j + 1));
          return;
        }
      }
    }
    output.println("NO");
  }
}
