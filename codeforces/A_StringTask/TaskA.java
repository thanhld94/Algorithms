import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    String s = input.next();
    StringBuilder sb = new StringBuilder();
    s = s.toLowerCase();
    for (int i = 0; i < s.length(); i++) {
      if (!isVowel(s.charAt(i))) {
        sb.append(".");
        sb.append(s.charAt(i));
      }
    }
    output.println(sb.toString());
    output.close();
  }

  private boolean isVowel(char c) {
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'y' || c == 'u') {
      return true;
    }
    return false;
  }
}
