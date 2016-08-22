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
    int n = input.nextInt();
    int m = input.nextInt();
    int count = 0;
    while (n >= 2 || m >= 2) {
      if (n == 0 || m == 0) {
        break;
      }
      count++;
      if (n > m && m > 0) {
        n -= 2;
        m--;
      } else {
        m -= 2;
        n--;
      }
    }
    output.println(count);
  }
}
