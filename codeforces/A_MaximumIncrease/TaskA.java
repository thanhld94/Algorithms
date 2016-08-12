import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int result = 1;
    int currentLength = 1;
    int previous = input.nextInt();
    for (int i = 1; i < n; i++) {
      int current = input.nextInt();
      if (current > previous) {
        currentLength++;
        result = Math.max(currentLength, result);
      } else {
        currentLength = 1;
      }
      previous = current;
    }
    output.println(result);
  }
}
