import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

  public static void main(String[] args) {
    TaskB tb = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tb.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = input.nextInt();
    }

    Arrays.sort(a);
    for (int num : b) {
      int idx = getFirstLargerIdx(a,num);
      output.print(idx + " ");
    }
    output.println();
  }

  private int getFirstLargerIdx(int[] arr, int target) {
    if (arr[arr.length - 1] <= target) {
      return arr.length;
    }
    int l = 0;
    int r = arr.length - 1;
    int result = 0;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] > target) {
        result = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return result;
  }
}
