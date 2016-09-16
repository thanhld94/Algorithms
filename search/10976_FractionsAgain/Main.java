import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main main = new Main();
    main.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    String line;
    StringTokenizer st;
    while ((line = input.readLine()) != null && line.length() > 0) {
      st = new StringTokenizer(line);
      int n = Integer.parseInt(st.nextToken());
      List<Integer> result = getResult(n);
      output.println(result.size());
      for (int val : result) {
        int other = (n * val) / (val - n);
        output.printf("1/%d = 1/%d + 1/%d\n", n, other, val);
      }
    }
  }

  private List<Integer> getResult(int n) {
    List<Integer> result = new ArrayList<Integer>();
    for (int i = n + 1; i <= 2 * n; i++) {
      if ((n * i) % (i - n) == 0) {
        result.add(i);
      }
    }
    return result;
  }
}
