import java.io.*;
import java.util.*;

public class Main {
  
  private static final int MAX = 40111;

  long[] digitCount = new long[MAX];
  long[] groups = new long[MAX];
  int[] lastNDigit = new int[7];
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(input.readLine());
    int test = Integer.parseInt(st.nextToken());
    for (int t = 0; t < test; t++) {
      st = new StringTokenizer(input.readLine());
      int n = Integer.parseInt(st.nextToken());
      output.println(getDigit(n));
    }
  }

  private void init() {
    // init last N digit = last number with n digit (n nines)
    for (int i = 1; i < 7; i++) {
      lastNDigit[i] = lastNDigit[i - 1] * 10 + 9;
    }

    // init group digits number
    for (int i = 1; i < MAX; i++) {
      groups[i] = 0L;
      for (int val : lastNDigit) {
        if (i > val) {
          groups[i] += sum(i - val);
        }
      }
    }

    // init digit in group x
    for (int i = 1; i < MAX; i++) {
      digitCount[i] = digitCount[i - 1] + countDigitInNum(i);
    }
  }

  // calculate sume 1 .. last
  private long sum(int last) { 
    return 1L * last * (last + 1) / 2;
  }

  private int countDigitInNum(int val) {
    int result = 0;
    while (val != 0) {
      result++;
      val /= 10;
    }
    return result;
  }

  private char getDigit(int n) {
    int group = binarySearch(groups, n);
    //System.out.println("group before target = " + group);
    int rem = n - (int) groups[group];
    //System.out.println("rem after group = " + rem);
    int num = binarySearch(digitCount, rem) + 1;
    //System.out.println("target num = " + num);
    rem -= digitCount[num - 1];
    //System.out.println("rem = " + rem);
    String result = "" + num;
    return result.charAt((int) (rem - 1));
  }

  private int binarySearch(long[] arr, long n) {
    int l = 0;
    int r = MAX - 1;
    int result = r;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] < n) {
        result = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return result;
  }
}
