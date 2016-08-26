import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    String pos = input.next();
    int row = pos.charAt(0) - 'a';
    int col = pos.charAt(1) - '1';
    int count = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i != 0 || j != 0) {
          int nr = row + i;
          int nc = col + j;
          if (nr >= 0 && nc >= 0 && nr < 8 && nc < 8) {
            count++;
          }
        }
      }
    }
    output.println(count);
  }
}
