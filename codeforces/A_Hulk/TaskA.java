import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {

  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(0,new Scanner(System.in), new PrintWriter(System.out));
  }

  private static final String[] feel = {"I hate", "I love"};

  public void solve(int testNumber, Scanner input, PrintWriter output) {
    int x = input.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < x - 1; i++) {
      sb.append(feel[i % 2]);
      sb.append(" that ");
    }
    sb.append(feel[(x - 1) % 2]);
    sb.append(" it");
    output.println(sb.toString());
    output.close();
  }
}
