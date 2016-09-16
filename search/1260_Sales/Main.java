import java.util.*;
import java.io.*;

public class Main {
  
  int n;
  int[] a = new int[1111];

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int test = Integer.parseInt(st.nextToken());
    for (int t = 0; t < test; t++) {
      st = new StringTokenizer(input.readLine());
      n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(input.readLine());
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }
      output.println(getsum());
    }
  }

  private int getsum() {
    int sum = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i] >= a[j]) {
          sum++;
        }
      }
    }
    return sum;
  }
}
