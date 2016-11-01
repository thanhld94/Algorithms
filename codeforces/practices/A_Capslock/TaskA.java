import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public static void main(String[] args) {
    TaskA ta = new TaskA();
    PrintWriter output = new PrintWriter(System.out);
    ta.solve(new Scanner(System.in), output);
    output.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    String text = input.next();
    boolean capcheck = true;
    for (int i = 1; i < text.length(); i++) {
      if ('A' > text.charAt(i) || text.charAt(i) > 'Z') {
        capcheck = false;
        break;
      }
    }

    if (capcheck) {
      char[] textchars = text.toLowerCase().toCharArray();
      textchars[0] = ('a' <= text.charAt(0) && text.charAt(0) <= 'z') ? (char) (textchars[0] + ('A' - 'a')) : textchars[0];
      for (char c : textchars) {
        output.print(c);
      }
      output.println();
    } else {
      output.println(text);
    }
  }
}
