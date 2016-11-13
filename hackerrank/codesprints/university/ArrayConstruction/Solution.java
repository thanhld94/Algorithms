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
  
  int[] coeff;
  int[] accumulate;
  int n;
  int k;
  int s;
  
  private void init(Scanner in) {
    n = in.nextInt();
    s = in.nextInt();
    k = in.nextInt();

    // init coefficient
    coeff = new int[n];
    coeff[n - 1] = 2*n - 1;
    for (int i = n - 2; i >= 0; i--) {
      coeff[i] = coeff[i + 1] - 2;
    }
    
    // init accumulate coeff
    accumulate = new int[n];
    accumulate[0] = 1;
    for (int i = 1; i < n; i++) {
      accumulate[i] = accumulate[i - 1] + coeff[i];
    }
  }
  
  private void solve(Scanner in, PrintWriter out) {
    int test = in.nextInt();
    for (int t = 0; t < test; t++) {
      init(in);
      int[] current = new int[n];
      List<List<Integer>> lists = new ArrayList<List<Integer>>();
      // generating
      generate(s, n * s + k, s, n - 1, current, lists);
      if (lists.size() == 0) { // no answer
        out.println(-1);
        continue;
      }
      {// print answer
        System.out.println(lists.size());
        int result = 0;
        for (int idx = 1; idx < lists.size(); idx++) {
          if (isSmaller(lists.get(idx), lists.get(result))) {
            result = idx;
          }
        }

        for (int val : lists.get(result)) {
          out.print(val + " ");
        }
        out.println();
      }
    }
  }
  
  private boolean isSmaller(List<Integer> list, List<Integer> current) {
    for (int idx = 0; idx < n; idx++) {
      int val = list.get(idx);
      int cur = current.get(idx);
      if (val != cur) {
        return val < cur;
      }
    }
    return false;
  }
  
  private void generate(int sum, int total, int previous, int idx, int[] current, List<List<Integer>> lists) {
    if (previous * accumulate[idx] < total) { // too small
      return;
    }
    if (sum / (idx + 1) > previous) return;
    if (idx == 0) { // last value will be the remaining
      if (sum != total) // remaining sum is not remaining total
        return;
      current[idx] = sum;
      List<Integer> next = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        next.add(current[i]);
        System.out.print(current[i] + " ");
      }
      System.out.println();
      lists.add(next);
      return;
    }
    for (int val = Math.min(previous, sum); val >= 0; val--) {
      if (val * coeff[idx] > total) continue;
      current[idx] = val;
      generate(sum - val, total - coeff[idx] * val, val, idx - 1, current, lists);
    }
  }
}
