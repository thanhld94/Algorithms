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
    int result = 0;
    int cap = 0;
    int current = 0;
    for (int i = 0; i < n; i++) {
      current = input.nextInt();
      cap = input.nextInt();
      if (cap - current >= 2) {
        result++;
      }
    }
    output.println(result);
  }
}
