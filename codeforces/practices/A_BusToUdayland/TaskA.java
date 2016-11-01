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
    int n = input.nextInt();
    String[] rows = new String[n];
    boolean found = false;
    for (int i = 0; i < n; i++) {
      rows[i] = input.next();
      if (!found && available(rows[i])) {
        rows[i] = getResult(rows[i]);
        found = true;
      }
    }
    if (!found) {
      output.println("NO");
    } else {
      output.println("YES");
      for (String row : rows) {
        output.println(row);
      }
    }
  }

  private String getResult(String row) {
    if (row.charAt(0) == 'O' && row.charAt(1) == 'O') {
      return "++|" + row.charAt(3) + row.charAt(4);
    }
    return "" + row.charAt(0) + row.charAt(1) + "|++"; 
  }

  private boolean available(String row) {
    if (row.charAt(0) == 'O' && row.charAt(1) == 'O') {
      return true;
    }
    if (row.charAt(3) == 'O' && row.charAt(4) == 'O') {
      return true;
    }
    return false;
  }
}
