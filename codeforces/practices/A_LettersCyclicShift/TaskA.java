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
    String text = input.next();
    int start = 0;
    while (start < text.length() && text.charAt(start) == 'a') {
      start++;
    }
   
    char[] result = text.toCharArray();
    if (start == text.length()) {
      result[result.length - 1] = 'z';
    }
    for (int i = start; i < result.length; i++) {
      if (result[i] == 'a') {
        break;
      }
      result[i] = (char) (result[i] - 1);
    }

    for (char c : result) {
      output.print(c);
    }
    output.println();
  }
}
