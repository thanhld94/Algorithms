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
    int len = input.nextInt();
    char[] colors = input.next().toCharArray();
    int result = 0;
    int current = 1;
    for (int i = 1; i < len; i++) {
      if (colors[i] == colors[i - 1]) {
        current++;
      } else {
        result += (current - 1);
        current = 1;
      }
    }
    result += current - 1;
    output.println(result);
  }
}
