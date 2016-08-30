/*
ID: thanhld1
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

public class transform {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("transform.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
    
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    char[][] mx = new char[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String s = st.nextToken();
      for (int j = 0; j < n; j++) {
        mx[i][j] = s.charAt(j);
      }
    }

    char[][] target = new char[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String s = st.nextToken();
      for (int j = 0; j < n; j++) {
        target[i][j] = s.charAt(j);
      }
    }

    transform sol = new transform();
    sol.solve(mx, target, output);
    output.close();
  }

  private void solve(char[][] mx, char[][] target, PrintWriter output) {
    for (int i = 1; i < 4; i++) {
      char[][] rotated = rotate(mx, i);
      if (isEqual(rotated, target)) {
        output.println(i);
        return;
      }
    }
    char[][] reflection = hReflect(mx);
    if (isEqual(reflection, target)) {
      output.println(4);
      return;
    }

    for (int i = 1; i < 4; i++) {
      char[][] rotated = rotate(reflection, i);
      if (isEqual(rotated, target)) {
        output.println(5);
        return;
      }
    }
    if (isEqual(mx, target)) {
      output.println(6);
      return;
    }
    output.println(7);
  }

  private char[][] rotate(char[][] mx, int x) { //x = 1 .. 3 -> 90 .. 270 degree
    int n = mx.length;
    char[][] result = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = mx[i][j];
      }
    }

    for (int t = 0; t < x; t++) {
      for (int layer = 0; layer < n/2; layer++) {
        for (int i = layer; i < n - layer - 1; i++) {
          char tmp = result[layer][i];
          result[layer][i] = result[n - i - 1][layer];
          result[n - i - 1][layer] = result[n - layer - 1][n - i - 1];
          result[n - layer - 1][n - i - 1] = result[i][n - layer - 1];
          result[i][n - layer - 1] = tmp;
        }
      }
    }
    return result;
  }

  private char[][] hReflect(char[][] mx) {
    int n = mx.length;
    char[][] result = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = mx[i][n - j - 1];
      }
    }
    return result;
  }
  
  private boolean isEqual(char[][] mx, char[][] other) {
    int n = mx.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (mx[i][j] != other[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
