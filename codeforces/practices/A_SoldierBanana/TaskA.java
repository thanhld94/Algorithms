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
    int k = input.nextInt();
    int n = input.nextInt();
    int w = input.nextInt();
    long total = k * w * (w + 1) / 2;
    long result = (total > n) ? total - n : 0;
    output.println(result);
  }
}
