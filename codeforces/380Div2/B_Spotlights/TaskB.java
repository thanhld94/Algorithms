import java.io.*;
import java.util.*;

public class TaskB {
  public static void main(String[] args) throws IOException {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    tB.solve(input, pw);
    pw.close();
  }

  int[] rowLeft = new int[1000];
  int[] rowRight = new int[1000];
  int[] colUp = new int[1000];
  int[] colDown = new int[1000];

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    String line = input.readLine();
    StringTokenizer st = new StringTokenizer(line);
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int result = 0;

    for (int i = 0; i < n; i++) {
      String text = input.readLine();
      st = new StringTokenizer(text);
      for (int j = 0; j < m; j++) {
        boolean actor = (Integer.parseInt(st.nextToken()) == 1);
        if (actor) {
          result -= 4;
          rowLeft[i] = Math.max(rowLeft[i], j + 1);
          rowRight[i] = Math.max(rowRight[i], m - j);
          colUp[j] = Math.max(colUp[j], i + 1);
          colDown[j] = Math.max(colDown[j], n - i);
        }
      }
    }
    for (int i = 0; i < 1000; i++) {
      result += colUp[i] + colDown[i];
      result += rowLeft[i] + rowRight[i];
    }
    output.println(result);
  }
}
