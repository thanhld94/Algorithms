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
    int row = 0;
    int col = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        int bit = input.nextInt();
        if (bit == 1) {
          row = i;
          col = j;
        }
      }
    }
    int result = Math.abs(2 - row) + Math.abs(2 - col);
    output.println(result);
  }
}
