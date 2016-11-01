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
    int k = input.nextInt();
    int r = input.nextInt();
    for (int i = 1; i <= 10; i++) {
      if ((k * i) % 10 == 0 || (k * i - r) % 10 == 0) {
        output.println(i);
        return;
      }
    }
  }
}
