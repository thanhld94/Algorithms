/*
ID: thanhld1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

public class frac1 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("frac1.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
    frac1 sol = new frac1();
    sol.solve(input, output);
    output.close();
  }

  private void solve(BufferedReader input, PrintWriter output) throws IOException {
    int n = Integer.parseInt(input.readLine());
    
    List<Fraction> result = new ArrayList<Fraction>();
    for (int denominator = 1; denominator <= n; denominator++) {
      for (int numerator = 0; numerator <= denominator; numerator++) {
        if (twinPrime(denominator, numerator)) {
          result.add(new Fraction(numerator, denominator));
        }
      }
    }
    Collections.sort(result);
    for (Fraction element : result) {
      output.println(element.numerator + "/" + element.denominator);
    }
  }

  private boolean twinPrime(int a, int b) {
    if (b == 0) {
      return a == 1;
    }
    int r = a % b;
    while (r != 0) {
      a = b;
      b = r;
      r = a % b;
    }
    return (b == 1);
  }

  private class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    private Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
    }

    @Override public int compareTo(Fraction other) {
      return numerator * other.denominator - other.numerator * denominator;
    }
  }
}
