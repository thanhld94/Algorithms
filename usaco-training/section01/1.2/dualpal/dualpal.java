/*
ID: thanhld1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
    dualpal sol = new dualpal();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int count = 0;
    int current = s + 1;
    while (count < n) {
      int cnt = 0;
      for (int base = 2; base <= 10; base++) {
        String num = getBase(current, base);
        if (palinCheck(num)) {
          cnt++;
          if (cnt >= 2) {
            output.println(current);
            count++;
            break;
          }
        }
      }
      current++;
    }
  }

  private String getBase(int x, int base) {
    List<Integer> list = new ArrayList<Integer>();
    while (x != 0) {
      list.add(x % base);
      x /= base;
    }

    StringBuilder result = new StringBuilder();
    for (int i = list.size() - 1; i >= 0; i--) {
      result.append(list.get(i));
    }
    return result.toString();
  }

  private boolean palinCheck(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
