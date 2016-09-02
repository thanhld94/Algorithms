/*
ID: thanhld1
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;

public class sprime {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("sprime.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
    sprime sol = new sprime();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    int n = Integer.parseInt(input.readLine());
    int[] digits = new int[n];
    genSuperPrime(n, digits, 0, output, 0);
  }

  private void genSuperPrime(int len, int[] digits, int idx, PrintWriter output, int currentVal) {
    if (idx == len) { // generated a complete number
      for (int digit : digits) {
        output.print(digit);
      }
      output.println();
      return;
    }
    
    currentVal *= 10;
    for (int digit = 0; digit <= 9; digit++) {
      if (digit == 0 && idx == 0) { //first digit cannot be zero
        continue;
      }
      if (isPrime(currentVal + digit)) {
        digits[idx] = digit;
        genSuperPrime(len, digits, idx + 1, output, currentVal + digit);
      }
    }
  }

  private boolean isPrime(int x) {
    if (x == 1) return false;
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) return false;
    }
    return true;
  }
}
