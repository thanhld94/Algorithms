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
    int x0 = input.nextInt();
    int y0 = input.nextInt();
    int n = input.nextInt();
    int x, y, v;
    double result = -1.0;
    for (int i = 0; i < n; i++) {
      x = input.nextInt();
      y = input.nextInt();
      v = input.nextInt();
      double distance = (1.0) * Math.sqrt((x - x0)*(x - x0) + (y - y0) * (y - y0));
      double time = distance / v;
      result = (result == -1) ? time : Math.min(result, time);
    }
    //output.printf("%.6f\n", result);
    output.println(result);
  }
}
