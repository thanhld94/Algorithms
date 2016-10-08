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
    
    int current = input.nextInt();
    int previous = -1;
    for (int i = 1; i < n; i++) {
      previous = current;
      current = input.nextInt();
    }

    if (current == 0) {
      output.println("UP");
      return;
    }

    if (current == 15) {
      output.println("DOWN");
      return;
    }

    if (n == 1) {
      output.println("-1");
      return;
    }

    if (current > previous) {
      output.println("UP");
    } else { 
      output.println("DOWN");
    }
  }
}
