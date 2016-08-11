import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    String s1 = input.next().toLowerCase();
    String s2 = input.next().toLowerCase();
    for (int i = 0; i < s1.length(); i++) {
      int c1 = s1.charAt(i);
      int c2 = s2.charAt(i);
      if (c1 < c2) {
        output.println(-1);
        output.close();
        return;
      } else if (c1 > c2) {
        output.println(1);
        output.close();
        return;
      }    
    }
    output.println(0);
    output.close();
  }
}
