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
    String text = input.next();
    int current = -1;
    int result = 0;
    for (int idx = 0; idx < text.length(); idx++) {
      if (isVowel(text.charAt(idx))) {
        result = Math.max(result, idx - current);
        current = idx;
      }
    }
    result = Math.max(result, text.length() - current);
    output.println(result);
  }

  private boolean isVowel(char c) {
    return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y';
  }
}
