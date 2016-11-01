import java.io.PrintWriter;
import java.util.*;

public class TaskA {
  
  private static final int[] posr = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2};
  private static final int[] posc = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
  private static final int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
  private static final int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    String text = input.next();
    boolean[] avail = new boolean[8];
    Arrays.fill(avail, true);

    for (int i = 0; i < n; i++) {
      int digit = text.charAt(i) - '0';
      int row = (digit == 0) ? 3 : (digit - 1) / 3;
      int col = (digit == 0) ? 1 : (digit - 1) % 3;
      //output.println("digit = " + digit + " row = " + row + " col = " + col);
      for (int dir = 0; dir < 8; dir++) {
        int nr = row + dx[dir];
        int nc = col + dy[dir];
        //output.println(dir + " -> " + nr + " " + nc);
        if (!found(nr, nc)) {
          //output.println("  => invalid");
          avail[dir] = false;
        }
      }
    }

    for (boolean check : avail) {
      if (check) {
        output.println("NO");
        return;
      }
    }
    output.println("YES");
  }

  private boolean found(int r, int c) {
    for (int i = 0; i < 10; i++) {
      if (r == posr[i] && c == posc[i]) {
        return true;
      }
    }
    return false;
  }
}
