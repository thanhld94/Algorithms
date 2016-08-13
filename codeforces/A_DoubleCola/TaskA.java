import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{
  private static final String[] NAMES = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt() - 1;
    int pow = 0; 
    while (5 * (1 << pow) <= n) {
      n -= (5 * (1 << pow));
      // System.out.println(pow + " " + n);
      pow++;
    }
    // output.println("rem = " + n);
    
    int result = n / (1 << pow);
    output.println(NAMES[result]);
  }
}
