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
    String text = input.next();
    boolean[] check = new boolean[5];
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == 'h') {
        check[0] = true;
      } else if (text.charAt(i) == 'e' && check[0]) {
        check[1] = true;
      } else if (text.charAt(i) == 'l' && check[0] && check[1]) {
        if (check[2]) {
          check[3] = true;
        } else {
          check[2] = true;
        }
      } else if (text.charAt(i) == 'o' && check[0] && check[1] && check[2] && check[3]) {
        output.println("YES");
        return;
      }
    }
    output.println("NO");
  }
}
