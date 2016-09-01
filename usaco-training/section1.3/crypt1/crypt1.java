/*
ID: thanhld1
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.*;

public class crypt1 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("crypt1.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
    crypt1 sol = new crypt1();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(input.readLine());
    
    int[] digits = new int[n];
    for (int i = 0; i < n; i++) {
      digits[i] = Integer.parseInt(st.nextToken());
    }

    ResultClass result = new ResultClass();
    int[] num = new int[5]; //num1 0..2, num2 3..4
    generate(num, 0, digits, result);
    output.println(result.value);
  }

  public void generate(int[] num, int idx, int[] digits, ResultClass result) {
    if (idx == num.length) {
      // check
      int num1 = num[0] * 100 + num[1] * 10 + num[2];
      int num2 = num[3] * 10 + num[4];
      if (num1 * num2 > 9999) {
        return;
      }
      if (num1 * num[4] > 999 || num1 * num[3] > 999) { // partial product is more than 3 digits
        return;
      }
      if (checkValid(num1 * num[4], digits) && checkValid(num1 * num[3], digits) && checkValid(num1 * num2, digits)) {
        //System.out.println(num1 + " " + num2);
        result.value++;
      }
      return;
    }
    for (int digit : digits) {
      if (idx == 0 || idx == 3) { // no leading zeroes
        if (digit == 0) continue;
      }
      num[idx] = digit;
      generate(num, idx + 1, digits, result);
    }
  }

  private boolean checkValid(int num, int[] digits) {
    while (num != 0) {
      boolean found = false;
      for (int digit : digits) {
        if (digit == num % 10) {
          found = true;
          break;
        }
      }
      if (!found) {
        return false;
      }
      num /= 10;
    }
    return true;
  }

  private class ResultClass {
    private int value;

    private ResultClass() {
      value = 0;
    }
  }
}
