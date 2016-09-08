/*
ID: thanhld1
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.*;

public class runround {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("runround.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
    runround sol = new runround();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int digitCount = getDigitCount(n);

    List<Integer> values = new ArrayList<Integer>();
    int[] current = new int[digitCount+1];
    boolean[] used = new boolean[10];
    generate(current, 0, digitCount, values, used);
    used = new boolean[10];
    generate(current, 0, digitCount + 1, values, used);
    output.println(binarySearch(n, values));
  }

  private int getDigitCount(int x) {
    int count = 0;
    while (x != 0) {
      count++;
      x /= 10;
    }
    return count;
  }

  private void generate(int[] current, int idx, int nDigits, List<Integer> result, boolean[] used) {
    if (idx == nDigits) {
      if (validRoundNumber(current, nDigits)) {
        result.add(getValue(current, nDigits));
        //System.out.println(getValue(current, nDigits));
      }
      return;
    }
    for (int digit = 1; digit <= 9; digit++) {
      if (!used[digit]) {
        current[idx] = digit;
        used[digit] = true;
        generate(current, idx + 1, nDigits, result, used);
        used[digit] = false;
      }
    }
  }

  private boolean validRoundNumber(int[] digits, int nDigits) {
    int idx = 0;
    boolean[] visited = new boolean[nDigits];
    do {
      idx += digits[idx];
      idx %= nDigits;
      if (visited[idx]) {
        return false;
      }
      visited[idx] = true;
    } while (idx != 0);
    for (boolean check : visited) {
      if (!check) return false;
    }
    return true;
  }

  private int getValue(int[] digits, int nDigits) {
    int value = 0;
    for (int idx = 0; idx < nDigits; idx++) {
      value = value * 10 + digits[idx];
    }
    return value;
  }

  private int binarySearch(int x, List<Integer> values) {
    int l = 0;
    int r = values.size() - 1;
    int result = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (values.get(mid) > x) {
        result = values.get(mid);
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return result;
  }
}
