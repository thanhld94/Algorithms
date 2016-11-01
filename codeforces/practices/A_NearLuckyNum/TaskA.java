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
    String number = input.next();
    int count = 0;
    for (int i = 0; i < number.length(); i++) {
      if (number.charAt(i) == '4' || number.charAt(i) == '7') {
        count++;
      }
    }
    if (lucky(count)) {
      output.println("YES");
    } else {
      output.println("NO");
    }
  }

  private boolean lucky(int x) {
    if (x == 0) {
      return false;
    }
    while (x > 0) {
      if (x % 10 != 4 && x % 10 != 7) {
        return false;
      }
      x /= 10;
    }
    return true;
  }
}
