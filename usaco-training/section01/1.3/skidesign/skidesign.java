/*
ID: thanhld1
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

public class skidesign {
  
  private static final int MAX_HEIGHT = 17;
  private static final int MAX_VAL = 100;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("skidesign.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
    skidesign sol = new skidesign();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    
    int[] heights = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      heights[i] = Integer.parseInt(st.nextToken());
    }
    
    int result = Integer.MAX_VALUE;
    for (int left = 0; left <= MAX_VAL - MAX_HEIGHT; left++) {
      int right = left + MAX_HEIGHT;
      int total = 0;
      for (int height : heights) {
        int cost = 0;
        if (height > right) {
          cost = height - right;
        } else if (height < left) {
          cost = left - height;
        }
        total += cost * cost;
      }
      result = Math.min(result, total);
    }
    output.println(result);
  }
}
