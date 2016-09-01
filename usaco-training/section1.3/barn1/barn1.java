/*
ID: thanhld1
LANG: JAVA
TASK: barn1
*/
import java.util.*;
import java.io.*;

public class barn1 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("barn1.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
    barn1 sol = new barn1();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int m = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int[] stalls = new int[c];
    for (int i = 0; i < c; i++) {
      st = new StringTokenizer(input.readLine());
      stalls[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(stalls);

    List <Integer> gaps = new ArrayList<Integer>();
    for (int i = 1; i < stalls.length; i++) {
      if (stalls[i] - stalls[i - 1] > 1) {
        gaps.add(stalls[i] - stalls[i - 1] - 1);
      }
    }
    Collections.sort(gaps);

    int total = c;
    for (int i = 0; i < gaps.size() - (m - 1); i++) {
      total += gaps.get(i);
    }
    output.println(total);
  }
}
