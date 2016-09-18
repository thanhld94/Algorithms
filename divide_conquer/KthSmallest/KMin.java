import java.util.*;
import java.io.*;

public class KMin {
  public static void main(String[] args) throws IOException { 
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    KMin sol = new KMin();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(input.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    arrange(arr, 0, n - 1, k);
    for (int i = 0; i < k; i++) {
      output.print(arr[i] + " ");
    }
    output.println();
  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private void arrange(int[] arr, int lower, int upper, int k) {
    if (k < lower || k > upper) {
      // throw exception
      return;
    }

    // partition by the last value
    int pos = partition(arr, lower, upper);
    
    // found correct partition
    if (pos - lower + 1 == k) {
      return;
    }

    // the target partition is on the left
    if (pos - lower + 1 > k) {
      arrange(arr, lower, pos - 1, k);
      return;
    }

    // partition on the right
    arrange(arr, pos + 1, upper, k - (pos - lower + 1));
  }

  private int partition(int[] arr, int lower, int upper) {
    int x = arr[upper];
    int i = lower;
    for (int j = lower; j < upper; j++) {
      if (arr[j] <= x) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, upper);
    return i;
  }
}
