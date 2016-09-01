/*
ID: thanhld1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("ariprog.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
    ariprog sol = new ariprog();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(input.readLine());
    int m = Integer.parseInt(st.nextToken());
    
    boolean[] bisquares = new boolean[m * m * 2 + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = i; j <= m; j++) {
        bisquares[i * i + j * j] = true;
      }
    }
    
    int max = 2 * m * m;
    
    List<Pair> result = new ArrayList<Pair>();
    for (int a = 0; a <= max; a++) {
      if (bisquares[a]) {
        for (int b = 1; b <= max; b++) {
          if (a + (n - 1) * b <= max) {
            int num = a;
            boolean check = true;
            for (int i = 1; i < n; i++) {
              num += b;
              if (!bisquares[num]) {
                check = false;
                break;
              }
            }
            if (check) {
              result.add(new Pair(a,b));
            }
          }
        }
      }
    }

    Collections.sort(result);
    if (result.size() == 0) {
      output.println("NONE");
    } else {
      for (Pair res : result) {
        output.println(res.first + " " + res.second);
      }
    }
  }

  private class Pair implements Comparable <Pair> {
    private int first;
    private int second;

    private Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override public int compareTo(Pair other) {
      if (second == other.second) {
        return first - other.first;
      }
      return second - other.second;
    }
  }
}
