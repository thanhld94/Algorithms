import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    String text = input.next();
    int idx = 0;
    int dotIdx = 0;
    int eIdx = 0;
    while (idx < text.length()) {
      if (text.charAt(idx) == '.') {
        dotIdx = idx;
      }
      if (text.charAt(idx) == 'e') {
        eIdx = idx;
      }
      idx++;
    }

    String num = text.substring(0, dotIdx);
    String decimal = text.substring(dotIdx + 1, eIdx);
    int exp = Integer.parseInt(text.substring(eIdx + 1));

    String result = getResult(num, decimal, exp);
    output.println(result);
  }

  private String getResult(String num, String decimal, int exp) {
    if (exp == 0) {
      if (decimal.equals("0")) {
        return num;
      } else {
        return num + "." + decimal;
      }
    }
    boolean zerochecked = true;
    if (Integer.parseInt(num) == 0) {
      zerochecked = false;
    }
    
    String result = num;
    int idx = 0;
    for (int i = 0; i < exp; i++) {
      char digit = (idx < decimal.length()) ? decimal.charAt(idx) : '0';
      result += digit;
      if (!zerochecked) {
        int val = Integer.parseInt(result);
        result = "" + val;
        if (val > 0) {
          zerochecked = true;
        }
      }
      idx++;
    }
    
    if (idx < decimal.length()) {
      result += ".";
      result += decimal.substring(idx);
    }
    return result;
  }
}
