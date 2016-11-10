import java.io.PrintWriter;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int q = input.nextInt();
    int[][] cell = new int[500][500];
    process(cell, 200, 200, n);
    for (int query = 0; query < q; query++) {
      int x = input.nextInt() + 200;
      int y = input.nextInt() + 200;
      if (x < 0 || y < 0 || x >= 500 || y >= 500) 
        output.println(0);
      else 
        output.println(cell[x][y]);
    }
  }

  private void process(int[][] cell, int x, int y, int val) {
    cell[x][y] += val;
    if (cell[x][y] < 4) return;
    cell[x][y] -= 4;
    process(cell, x + 1, y, 1);
    process(cell, x - 1, y, 1);
    process(cell, x, y - 1, 1);
    process(cell, x, y + 1, 1);
    process(cell, x, y, 0);
  }
}
