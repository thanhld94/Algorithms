import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int k = input.nextInt();
    int nOdd = 0;
    int nEven = 0;
    for (int i = 0; i < n; i++) {
      int num = input.nextInt();
      if (num % 2 == 0) 
        nEven++;
      else
        nOdd++;
    }
    
    if (k == n) {
      if (nOdd % 2 == 0) {
        output.println("Daenerys");
      } else {
        output.println("Stannis");
      }
      return;
    }

    int nturns = n - k;
    int nDaenerys = (n - k)/2;
    int nStannis = (nturns % 2 == 0) ? nDaenerys : nDaenerys + 1;

    if (nturns % 2 == 0) { // Daenerys makes the last move
      if (nEven > nStannis) { // if Stannis cannot remove all the even numbers
        output.println("Daenerys");
      } else {
        nOdd -= (nStannis - nEven);
        if (nOdd % 2 == nDaenerys % 2) {
          output.println("Daenerys");
        } else {
          output.println("Stannis");
        }
      }
    } else { // Stannis makes the last move
      if (nOdd > nDaenerys) { // If Daenerys cannot remove all the odd numbers
        if (nEven > nDaenerys) {
          output.println("Stannis");
        } else {
          nOdd -= (nDaenerys - nEven);
          if (nOdd % 2 == nStannis % 2) {
            output.println("Daenerys");
          } else {
            output.println("Stannis");
          }
        }
      } else {
        output.println("Daenerys");
      }
    }
  }
}
