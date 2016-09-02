/*
ID: thanhld1
LANG: JAVA
TASK: beads
*/

import java.util.*;
import java.io.*;

public class beads {
  
  public static void main(String[] args) throws IOException {
    beads sol = new beads();
    sol.solve();
  }

  private boolean valid(char current, int idx, String s) {
    return (current == 'w' || s.charAt(idx) == 'w' || s.charAt(idx) == current); 
  }
  
  private int getCount(String s, int brk) {
    int count = 0;
    char current = 'w';
    int n = s.length();
    boolean[] marked = new boolean[n];

    for (int i = 0; i < n; i++) {
      int idx = (brk + i < n) ? brk + i : brk + i - n;
      if (!valid(current, idx, s)) {
        break;
      }
      count++;
      marked[idx] = true;
      if (s.charAt(idx) != 'w') {
        current = s.charAt(idx);
      }
    }

    current = 'w';
    for (int i = 1; i <= n; i++) {
      int idx = (brk - i < 0) ? brk - i + n : brk - i;
      if (marked[idx]) {
        continue;
      }
      if (!valid(current, idx, s)) {
        break;
      }

      count++;
      if (s.charAt(idx) != 'w') {
        current = s.charAt(idx);
      }
    }
    return count; 
  }

  public void solve() throws IOException{
    BufferedReader input = new BufferedReader(new FileReader("beads.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    StringTokenizer st = new StringTokenizer(input.readLine());

    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(input.readLine());
    String s = st.nextToken();
    
    int result = -1;

    for (int brk = 0; brk < n; brk++) {
     int count = getCount(s, brk);
     result = Math.max(result, count);
    }
    output.println(result);
    output.close();
  }
}
