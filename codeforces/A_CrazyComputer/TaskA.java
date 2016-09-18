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
    int n = input.nextInt();
    int c = input.nextInt();
    int count = 1;
    int last = input.nextInt();
    for (int i = 1; i < n; i++) {
      int next = input.nextInt();
      if (next - last > c) {
        count = 0;
      }
      count++;
      last = next;
    }
    output.println(count);
  }
}
