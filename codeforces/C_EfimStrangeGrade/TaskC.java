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
    int t = input.nextInt();
    t = Math.min(t, n); 
    char[] digits = input.next().toCharArray();
    int first = 0;
    int period = 0; 
    for (first = 0; first < n; first++) {
      if (digits[first] == '.') {
        period = first; 
        break;
      }
    }

    while (first < n && !canUp(digits, first, period)) first++;
    if (first == n) {
      print(digits, output, period);
      return;
    }

    while (t > 0 && first >= 0) {
      if (canUp(digits, first, period)) {
        first = upDigit(digits, first); 
      }
      t--;
    }
    if (first < 0 && digits[0] == '-') {
      output.print(1);
    }
    print(digits, output, period);
  }

  private boolean canUp(char[] digits, int idx, int period) {
    if (idx < period) return false;
    if (idx == digits.length - 1) return false; 
    return (digits[idx + 1] >= '5' && digits[idx + 1] <= '9');
  }

  private int upDigit(char[] digits, int idx) {
    if (idx < 0) {
      digits[0] = '-'; 
      return -1; 
    }
    if (digits[idx] == '.') {
      return upDigit(digits, idx - 1);
    }
    digits[idx + 1] = '-';
    if (digits[idx] == '9') {
      digits[idx] = '0';
      return upDigit(digits, idx - 1);
    }  
    digits[idx]++;  
    return idx - 1;  
  }

  private void print(char[] digits, PrintWriter output, int period) {
    for (int i = 0; i < period; i++) {
      if (digits[i] == '-') 
        output.print(0);
      else 
        output.print(digits[i]);
    }
    for (int i = period; i < digits.length; i++) {
      if (digits[i] == '-') {
        break;
      }
      output.print(digits[i]);
    }
    output.println();
  }
}
