import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Solution sol = new Solution();
    sol.solve(in, out);
    out.close();
  }
  
  private void solve(Scanner in, PrintWriter out) {
    int test = in.nextInt();
    for (int t = 0; t < test; t++) {
      int n = in.nextInt();
      long sum = 0L;
      int nn = 0;
      for (int i = 0; i < n; i++) {
        int m = in.nextInt();
        int k = in.nextInt();
        if (m != 2) {
          nn++;
          sum += m;
        }
      }
      if (nn % 2 == 1) {
        out.println("BOB");
        continue;
      }
      if (sum % 2 == 0) {
        out.println("BEN");
      } else {
        out.println("BOB");
      }
    }
  }
}