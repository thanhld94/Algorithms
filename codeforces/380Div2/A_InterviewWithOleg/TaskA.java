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
    String text = input.next();
    for (int i = 0; i < text.length(); i++) {
      boolean found = false;
      for (int j = text.length() - 1; j >= i + 2; j--) {
        if (isFilter(text, i, j)) {
          found = true;
          i = j;
          break;
        }
      }
      if (found) {
        output.print("***");
        continue;
      }
      output.print(text.charAt(i));
    }
    output.println();
  }

  private boolean isFilter(String text, int start, int end) {
    if ((end - start + 1) % 2 == 0) return false;
    char[] match = {'o', 'g'};
    int idx = 0;
    for (int i = start; i <= end; i++) {
      if (text.charAt(i) != match[idx]) return false;
      idx = 1 - idx;
    }
    return true;
  }
}
