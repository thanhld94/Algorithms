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
    boolean[] count = new boolean[26];
    String text = input.next();
    for (int i = 0; i < text.length(); i++) {
      count[text.charAt(i) - 'a'] = true;
    }
    
    int result = 0;
    for (boolean app : count) {
      if (app) {
        result++;
      }
    }
    String ans = (result % 2 == 1) ? "IGNORE HIM!" : "CHAT WITH HER!";
    output.println(ans);
  }
}
