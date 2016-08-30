/*
ID: thanhld1
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.*;

public class palsquare {
  
  private static final char[] BASECHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                                          'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'};

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
    palsquare solution = new palsquare();
    solution.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int base = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= 300; i++) {
      int num = i;
      int sqr = num * num;
      String newBase = getBase(sqr, base);
      if (palinCheck(newBase)) {
        output.println(getBase(num, base) + " " + newBase);
      }
    }
  }

  private String getBase(int val, int base) {
    List <Character> list = new ArrayList<Character>();
    while (val != 0) {
      list.add(BASECHAR[val % base]);
      val /= base;
    }
    
    StringBuilder result = new StringBuilder();
    for (int i = list.size() - 1; i >= 0; i--) {
      result.append(list.get(i));
    }
    return result.toString();
  }

  private boolean palinCheck(String s) {
    for (int i = 0; i <= s.length()/2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
