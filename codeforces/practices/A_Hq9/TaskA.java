import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    ta.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    String s = input.next();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'H' || s.charAt(i) == 'Q' || s.charAt(i) == '9') {
        output.println("YES");
        return;
      }
    }
    output.println("NO");
  }
}
