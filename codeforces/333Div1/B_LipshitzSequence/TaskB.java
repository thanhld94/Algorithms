import java.io.*;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    Scanner input = new Scanner(System.in);
    PrintWriter output = new PrintWriter(System.out);
    tB.solve(input, output);
    output.close();
  }

  private int n, q;
  private int[] a;
  private int[] diff;
  private int[] stack;
  private int[] lengthLeft;
  private int[] lengthRight;

  public void solve(Scanner input, PrintWriter output) {
    n = input.nextInt();
    q = input.nextInt();

    a = new int[n];
    for(int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }

    diff = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      diff[i] = Math.abs(a[i] - a[i + 1]);
    }

    stack = new int[n];
    lengthLeft = new int[n - 1];
    lengthRight = new int[n - 1];
    // if i < j < k then L(i,j) or L(j,k) >= L(i,k)
    for (int query = 0; query < q; query++) {
      int low = input.nextInt() - 1;
      int high = input.nextInt() - 1;

      countLeft(low, high);
      countRight(low, high);
      long result = 0L;
      for (int idx = low; idx < high; idx++) {
        result += (1L) * diff[idx] * lengthLeft[idx] * lengthRight[idx];
      }
      output.println(result);
    }
  }

  // lengthLeft[i] the max length of the sequence (j,i) where j <= i such that a[i] >= a[j]
  private void countLeft(int low, int high) {
    Arrays.fill(lengthLeft, 0);
    int top = -1;
    for (int i = low; i < high; i++) {
      lengthLeft[i] = 1;
      if (top >= 0) { // not empty
        while (top >= 0 && diff[stack[top]] <= diff[i])
          lengthLeft[i] += lengthLeft[stack[top--]];
      }
      stack[++top] = i;
    }
  }

  // lengthRight[i] same as lengthLeft, but to the right but a[i] > a[j] if j != i
  private void countRight(int low, int high) {
    Arrays.fill(lengthRight, 0);
    int top = -1;
    for (int i = high - 1; i >= low; i--) {
      lengthRight[i] = 1;
      if (top >= 0) { // not empty
        while (top >= 0 && diff[stack[top]] < diff[i]) 
          lengthRight[i] += lengthRight[stack[top--]];
      }
      stack[++top] = i;
    }
  }
}
