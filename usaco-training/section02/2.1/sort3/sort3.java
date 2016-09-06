/*
ID: thanhld1
LANG: JAVA
TASK: sort3
*/

import java.util.*;
import java.io.*;

public class sort3 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("sort3.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
    sort3 sol = new sort3();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] seq = new int[n];
    int[] sorted = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      seq[i] = Integer.parseInt(st.nextToken());
      sorted[i] = seq[i];
    }
    Arrays.sort(sorted);
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (seq[i] == sorted[i]) continue;
      boolean found = false;
      for (int j = i + 1; j < n; j++) {
        if (seq[j] == sorted[i] && sorted[j] == seq[i]) {
          swap(seq, i, j);
          count++;
          found = true;
          break;
        }
      }

      if (!found) {
        for (int j = i + 1; j < n; j++) {
          if (seq[j] == sorted[i] && sorted[j] != seq[j]) {
            count++;
            swap(seq, i, j);
            break;
          }
        }
      }
    }
    output.println(count);
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
