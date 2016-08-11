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
    int n = input.nextInt();
    for (int i = 1; i <= n; i++) {
      if (n % i == 0 && lucky(i)) {
        output.println("YES");
        return;
      }
    }
    output.println("NO");
  }
  
  private boolean lucky(int n) {
    while (n > 0) {
      if (n % 10 != 4 && n % 10 != 7) {
        return false;
      }
      n /= 10;
    }
    return true;
  }
}
