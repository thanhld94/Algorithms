import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB {
  
  public static void main(String[] args) {
    TaskB tb = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tb.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int t = input.nextInt();
    char[] line = input.next().toCharArray();
    for (int i = 0; i < t; i++) {
      int idx = 0;
      while (idx < n - 1) {
        if (line[idx] == 'B' && line[idx + 1] == 'G') {
          line[idx] = 'G';
          line[idx + 1] = 'B';
          idx += 2;
        } else {
          idx++;
        }
      }
    }
    for (char position : line) {
      output.print(position);
    }
    output.println();
  }
}
