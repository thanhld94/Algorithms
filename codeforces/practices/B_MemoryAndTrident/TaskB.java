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
    String text = input.next();
    if (text.length() % 2 == 1) {
      output.println(-1);
      return;
    }
    int[] diff = new int[4];
    for (int i = 0; i < text.length(); i++) {
      diff[getPos(text.charAt(i))]++;
    }

    int result = (Math.abs(diff[0] - diff[1]) + Math.abs(diff[2] - diff[3])) / 2;
    output.println(result);
  }

  private int getPos(char c) {
    if (c == 'U') return 0;
    if (c == 'D') return 1;
    if (c == 'R') return 2;
    return 3;
  }
}
