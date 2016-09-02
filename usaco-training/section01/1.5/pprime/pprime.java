/*
ID: thanhld1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;

public class pprime {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("pprime.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
    pprime sol = new pprime();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int nDigit = countDigit(b); 
    int[] digits = new int[nDigit];
    for (int len = 1; len <= nDigit; len++) {
      gen(len, 0, digits, a, b, output);
    }
  }

  private int countDigit(int x) {
    int count = 0;
    while (x != 0) {
      count++;
      x /= 10;
    }
    return count;
  }

  private boolean isPrime(int x) {
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) return false;
    }
    return true;
  }

  private void gen(int len, int idx, int[] digits, int a, int b, PrintWriter output) {
    if ((len % 2 == 0 && idx >= len / 2) || (len % 2 == 1 && idx > len / 2)) {
      int val = 0;
      for (int i = 0; i < len; i++) {
        val = val * 10 + digits[i];
      }
      if (val < a || val > b) {
        return;
      }
      if (isPrime(val)) {
        output.println(val);
      }
      return;
    }
    for (int digit = 0; digit <= 9; digit++) {
      if (idx == 0 && digit == 0) {
        continue;
      }
      digits[idx] = digit;
      digits[len - idx - 1] = digit;
      gen(len, idx + 1, digits, a, b, output);
    }
  }
}
