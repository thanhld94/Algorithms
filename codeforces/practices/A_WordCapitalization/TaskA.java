import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    ta.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    char[] text = input.next().toCharArray();
    text[0] = ('a' <= text[0] && text[0] <= 'z') ? (char) (text[0] + 'A' - 'a') : text[0];
    for (char c : text) {
      output.print(c);
    }
    output.println();
  }
}

