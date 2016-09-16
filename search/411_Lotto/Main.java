import java.io.*;
import java.util.*;

public class Main {
  
  int n;
  int[] s = new int[13];
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    n = Integer.parseInt(st.nextToken());
    while (n != 0) {
      for (int i = 0; i < n; i++) {
        s[i] = Integer.parseInt(st.nextToken());
      }
      printResult(output);
      st = new StringTokenizer(input.readLine());
      n = Integer.parseInt(st.nextToken());
      if (n != 0) 
        output.println();
    }
  }

  private void printResult(PrintWriter output) {
    for (int i1 = 0; i1 < n - 5; i1++) 
      for (int i2 = i1 + 1; i2 < n - 4; i2++)
        for (int i3 = i2 + 1; i3 < n - 3; i3++) 
          for (int i4 = i3 + 1; i4 < n - 2; i4++) 
            for (int i5 = i4 + 1; i5 < n - 1; i5++) 
              for (int i6 = i5 + 1; i6 < n; i6++) 
                output.println(s[i1] + " " + s[i2] + " " + s[i3] + " " + s[i4] + " " + s[i5] + " " + s[i6]);
  }
}
