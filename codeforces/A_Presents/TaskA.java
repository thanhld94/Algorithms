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
    int[] presents = new int[n];
    for (int i = 0; i < n; i++) {
      int receiver = input.nextInt();
      presents[receiver - 1] = i + 1;
    }
    for (int present : presents) {
      output.print(present + " ");
    }
    output.println();
  }
}
