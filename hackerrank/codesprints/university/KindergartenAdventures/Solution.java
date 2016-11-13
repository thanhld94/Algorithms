import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
  Solution sol = new Solution();
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    sol.solve(in, out);
    out.close();
  }
  
  private static final int MAX = 100000;
  int[] tree = new int[100111 * 4];
  int[] wait = new int[100111 * 4];
  int n;
  int[] t;
  
  private void solve(Scanner in, PrintWriter out) {
    n = in.nextInt();
    t = new int[n];
    for (int i = 0; i < n; i++) {
      t[i] = in.nextInt();
    }
    
    for (int idx = 0; idx < n; idx++) {
      if (idx - t[idx] >= 0) {
        update(0, n - 1, 0, idx - t[idx], 0);
        update(0, n - 1, idx + 1, n - 1, 0);
      } else {
        update(0, n - 1, idx + 1, n + idx - t[idx], 0);
      }
    }

    int result = -1;
    int max = -1;
    for (int i = 0; i < n; i++) {
      int val = get(0, n - 1, i, 0);
      if (val > max) {
        result = i;
        max = val;
      }
    }
    out.println(result + 1);
  }

  private void update(int left, int right, int low, int high, int idx) {
    if (right < low || high < left) // non intersect
      return;
    if (low <= left && right <= high) { // within the range
      tree[idx]++;
      wait[idx]++;
      return;
    }

    if (wait[idx] > 0) 
      updateChild(idx, left, right);
    int mid = left + (right - left)/2;
    update(left, mid, low, high, idx * 2 + 1);
    update(mid + 1, right, low, high, idx * 2 + 2);
  }

  private int get(int left, int right, int pos, int idx) {
    if (pos < left || right < pos) // no intersect
      return 0;
    if (left == right) 
      return tree[idx];
    if (wait[idx] > 0)
      updateChild(idx, left, right);
    int mid = left + (right - left)/2;
    if (pos <= mid) return get(left, mid, pos, idx * 2 + 1);
    return get(mid + 1, right, pos, idx * 2 + 2);
  }

  private void updateChild(int idx, int left, int right) {
    int mid = left + (right - left)/2;
    tree[idx * 2 + 1] += wait[idx];
    wait[idx * 2 + 1] += wait[idx];
    tree[idx * 2 + 2] += wait[idx];
    wait[idx * 2 + 2] += wait[idx];
    wait[idx] = 0;
  }
}
