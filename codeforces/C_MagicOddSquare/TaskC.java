import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[][] result = new int[n][n];
    int count = 2;
    int lcol = 0;
    int rcol = n - 1;
    int trow = 0;
    int brow = n - 1;
    while (lcol < rcol) {
      int tr = trow;
      int br = brow;
      while (tr < br && count < n * n) {
        result[tr][lcol] = count;
        count += 2;
        result[tr][rcol] = count;
        count += 2;
        result[br][lcol] = count;
        count += 2;
        result[br][rcol] = count;
        count += 2;
        tr++;
        br--;
      }
      trow++;
      brow--;
      lcol++;
      rcol--;
    }
    count = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (result[i][j] == 0) {
          result[i][j] = count;
          count += 2;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        output.print(result[i][j] + " ");
      }
      output.println();
    }
  }
}
