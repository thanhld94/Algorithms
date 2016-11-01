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
    int year = input.nextInt();
    while (true) {
      if (beautiful(++year)) {
        output.println(year);
        return;
      }
    }
  }

  private boolean beautiful(int year) {
    boolean[] appeared = new boolean[10];
    while (year > 0) {
      int digit = year % 10;
      if (appeared[digit]) return false;
      appeared[digit] = true;
      year /= 10;
    }
    return true;
  }
}
