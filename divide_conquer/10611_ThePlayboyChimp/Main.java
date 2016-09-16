import java.util.*;
import java.io.*;

public class Main {

  private enum Type {
    LOW, HIGH
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] heights = new int[n];

    st = new StringTokenizer(input.readLine());
    for (int i = 0; i < n; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(input.readLine());
    int q = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(input.readLine());
    for (int i = 0; i < q; i++) {
      int query = Integer.parseInt(st.nextToken());
      int low = binarySearch(heights, query, Type.LOW);
      int high = binarySearch(heights, query, Type.HIGH);
      String result = "";
      result += ((low == -1) ? "X" : low);
      result += " ";
      result += ((high == -1) ? "X" : high);
      output.println(result);
    }
  }

  private int binarySearch(int[] heights, int bound, Type type) {
    int l = 0;
    int r = heights.length - 1;
    int result = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      
      // search for the highest that is lower
      if (type == Type.LOW) {
        if (heights[mid] < bound) {
          result = heights[mid];
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else { // search for the lowest that is higher
        if (heights[mid] > bound) {
          result = heights[mid];
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }
    return result;
  }
}
