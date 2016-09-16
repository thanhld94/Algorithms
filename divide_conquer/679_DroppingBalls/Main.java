import java.io.*;
import java.util.*;

public class Main {
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
      int depth = Integer.parseInt(st.nextToken());
      if (depth == -1) {
        break;
      }
      int value = Integer.parseInt(st.nextToken());
      
      output.println(getNode(value, depth));
    }
  }

  private int getNode(int value, int depth) {
    int result = (1 << (depth - 1));
    int base = result / 2;

    while (value != 1) {
      if (value % 2 == 0) {
        result += base;
      }
      base /= 2;
      value = (value + 1) / 2;
    }
    return result;
  }
}
