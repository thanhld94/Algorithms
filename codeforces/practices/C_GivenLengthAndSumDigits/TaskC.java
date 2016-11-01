import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int m = input.nextInt();
    int sum = input.nextInt();
    int[][] digit = new int[m][2];
    int s = sum;
    for (int i = 9; i > 0; i--) {
      if (s >= i) {
        digit[0][1] = i;
        s -= i;
        break;
      }
    }
    if (digit[0][1] == 0 && m > 1) {
      output.println("-1 -1");
      return;
    }

    //get max
    for (int i = 1; i < m; i++) {
      for (int j = 9; j >= 0; j--) {
        if (s >= j) {
          digit[i][1] = j;
          s -= j;
          break;
        }
      }
    }
      
    if (s > 0) {
      output.println("-1 -1");
      return;
    }

    //get min
    for (int i = m - 1; i > 0; i--) {
      for (int j = 9; j >= 0; j--) {
        if (sum > j) {
          digit[i][0] = j;
          sum -= j;
          break;
        }
      }
    }
    digit[0][0] = sum;
    
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < m; j++) {
        output.print(digit[j][i]);
      }
      output.print(" ");
    }
    output.println();
  }
}
