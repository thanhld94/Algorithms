import java.io.*;
import java.util.*;

public class TaskC {
  public static void main(String[] args) throws IOException {
    TaskC tC = new TaskC();
    PrintWriter out = new PrintWriter(System.out);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    tC.solve(in, out);
    out.close();
  }

  int n, m;

  public void solve(BufferedReader in, PrintWriter out) throws IOException {
    String line = in.readLine();
    StringTokenizer st = new StringTokenizer(line);
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // input
    int minimumIntervalLength = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      line = in.readLine();
      st = new StringTokenizer(line);
      int begin = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      minimumIntervalLength = Math.min(minimumIntervalLength, end - begin + 1);
    }

    // process
    out.println(minimumIntervalLength);
    for (int i = 0; i < n; i++) {
      out.print((i % minimumIntervalLength) + " ");
    }
    out.println();
  }
}
