import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    String num = input.next();
    int result = 0;
    for (int i = 0; i < num.length(); i++) {
      int digit0 = num.charAt(i) - '0';
      result = digit0;
      if (result % 8 == 0) {
        output.println("YES");
        output.println(result);
        return;
      }
      for (int j = i + 1; j < num.length(); j++) {
        int digit1 = num.charAt(j) - '0';
        result = digit0 * 10 + digit1;
        if (result % 8 == 0) {
          output.println("YES");
          output.println((digit0 * 10 + digit1));
          return;
        }
        for (int k = j + 1; k < num.length(); k++) {
          int digit2 = num.charAt(k) - '0';
          result = digit0 * 100 + digit1 * 10 + digit2;
          if (result % 8 == 0) {
            output.println("YES");
            output.println(result);
            return;
          }
        }
      }
    }
    output.println("NO");
  }
}
