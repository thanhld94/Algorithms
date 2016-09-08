import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int q = input.nextInt();

    char[] text = input.next().toCharArray();
    int result = 0;
    int current = 0; 
    for (int i = 0; i < text.length; i++) {
      //output.println(text[i] + " " + current);
      if (text[i] == '.') {
        current++;
      } else {
        if (current > 0) {
          //output.println("  added " + (current - 1));
          result += (current - 1);
        }
        current = 0;
      }
    }
    
    if (current > 0) {
      result += (current - 1);
    }
    //output.println("init = " + result);

    for (int i = 0; i < q; i++) {
      int idx = input.nextInt() - 1;
      char letter = input.next().charAt(0);
      if ((letter == '.' && text[idx] == '.') || (letter != '.' && text[idx] != '.')) {
        output.println(result);
        continue;
      }

      if (letter != '.') {
        int left = (idx - 1 < 0 || text[idx - 1] != '.') ? 0 : -1;
        int right = (idx + 1 >= n || text[idx + 1] != '.') ? 0 : -1;
        result = result + left + right;
        output.println(result);
        text[idx] = letter;
        continue;
      }
      
      if (idx + 1 < n && text[idx + 1] == '.') {
        result++;
      }
      if (idx - 1 >= 0 && text[idx - 1] == '.') {
        result++;
      }
      text[idx] = letter;
      output.println(result);
    }
  }
}
