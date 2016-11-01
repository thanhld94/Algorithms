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
  	int m = input.nextInt();
  	if (m > n) {
      output.println(-1);
    } else {
      int minsteps = (n + 1) / 2;
      int total = minsteps;
      if (minsteps % m != 0) {
        total += (m - minsteps % m);
      }
      output.println(total);
    }
  }
}
