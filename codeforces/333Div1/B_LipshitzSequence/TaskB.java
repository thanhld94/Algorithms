import java.io.*;
import java.util.*;

public class TaskB {
  public static void main(String[] args) throws IOException {
    TaskB tB = new TaskB();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tB.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(input.readLine());
    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    // absolute difference between a[i] and a[i + 1]
    // if i < j < k then L(i,j) or L(j,k) >= L(i,k)
    int[] diff = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      diff[i] = Math.abs(a[i] - a[i + 1]);
    }

    
    for (int query = 0; query < q; query++) {
      st = new StringTokenizer(input.readLine());
      int low = Integer.parseInt(st.nextToken()) - 1;
      int high = Integer.parseInt(st.nextToken()) - 2;
      int[] lengthLeft = countLeft(diff, low, high); 
      int[] lengthRight = countRight(diff, low, high); 

      if (low > high) {
        output.println(0);
        continue;
      }
      long result = 0L;
      for (int idx = low; idx <= high; idx++) {
        result += (1L) * diff[idx] * lengthLeft[idx] * lengthRight[idx];
      }
      output.println(result);
    }
  }

  // lengthLeft[i] the max length of the sequence (j,i) where j <= i such that a[i] >= a[j]
  private int[] countLeft(int[] arr, int left, int right) {
    int[] count = new int[arr.length];
    Stack<Cell> stack = new Stack<Cell>();
    for (int idx = left; idx <= right; idx++) {
      count[idx] = 1;
      if (!stack.empty()) {
        while (!stack.empty() && stack.peek().value <= arr[idx]) {
          Cell top = stack.pop();
          count[idx] += count[top.idx];
        }
      }
      stack.push(new Cell(idx, arr[idx]));
    }
    return count;
  }

  // lengthRight[i] same as lengthLeft, but to the right but a[i] > a[j] if j != i
  private int[] countRight(int[] arr, int left, int right) {
    int[] count = new int[arr.length];
    Stack<Cell> stack = new Stack<Cell>();
    for (int idx = right; idx >= left; idx--) {
      count[idx] = 1;
      if (!stack.empty()) {
        while (!stack.empty() && stack.peek().value < arr[idx]) {
          Cell top = stack.pop();
          count[idx] += count[top.idx];
        }
      }
      stack.push(new Cell(idx, arr[idx]));
    }
    return count;
  }

  private class Cell {
    private int idx;
    private int value;

    private Cell(int idx, int value) {
      this.idx = idx;
      this.value = value;
    }
  }
}
