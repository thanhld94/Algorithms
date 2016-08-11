import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    String text = input.next();
    if (text.length() < 7) {
      output.println("NO");
      output.close();
      return;
    }
    int result = 0;
    int current = 1;
    for (int i = 1; i < text.length(); i++) {
      if (text.charAt(i) == text.charAt(i-1)) {
        current++;
      } else {
        result = Math.max(result, current);
        if (result >= 7) {
          output.println("YES");
          output.close();
          return;
        }
        current = 1;
      }
    }
    if (current >= 7) {
      output.println("YES");
    } else {
      output.println("NO");
    }
    output.close();
  }
}
