/*
ID: thanhld1
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

public class preface {
  
  private static final char[] ROMAN = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
  private static final int[] ROMAN_NUM = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
  private static final String[] ROMAN_STRING = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("preface.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
    preface sol = new preface();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    Map <Character, Integer> countChar = new HashMap<Character, Integer>();
    for (char roman : ROMAN) {
      countChar.put(roman, 0);
    }

    for (int i = 1; i <= n; i++) {
      String roman = convertToRoman(i);
      //System.out.println(i + ": " + roman);
      for (int idx = 0; idx < roman.length(); idx++) {
        countChar.put(roman.charAt(idx), countChar.get(roman.charAt(idx)) + 1);
      }
    }

    for (char c : ROMAN) {
      if (countChar.get(c) > 0) {
        output.println(c + " " + countChar.get(c));
      }
    }
  }

  private String convertToRoman(int x) {
    String result = "";
    int idx = ROMAN_NUM.length - 1;
    while (x > 0) {
      while (x < ROMAN_NUM[idx]) idx--;
      while (x >= ROMAN_NUM[idx]) {
        x -= ROMAN_NUM[idx];
        result += ROMAN_STRING[idx];
      }
    }
    return result;
  }
}
