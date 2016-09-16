import java.util.*;
import java.io.*;

public class Main {
  
  private int nc;
  private int[] c = new int[25];
  private int d;
  private int k;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main main = new Main();
    main.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int test = Integer.parseInt(st.nextToken());
    for (int t = 0; t < test; t++) {
      st = new StringTokenizer(input.readLine());
      nc = Integer.parseInt(st.nextToken());
      //System.out.println("nc = " + nc);
      for (int i = 0; i <= nc; i++) {
        c[i] = Integer.parseInt(st.nextToken());
        //System.out.println(" " + i + " - " + c[i]);
      }
      st = new StringTokenizer(input.readLine());
      d = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(input.readLine());
      k = Integer.parseInt(st.nextToken());
      
      int idx = 0;
      long coeff = 0L;
      while (coeff * d < k) {
        idx++;
        coeff += idx;
      }

      long result = getResult(idx);
      output.println(result);
    }
  }

  private long getResult(int idx) {
    long result = 0;
    for (int i = 0; i <= nc; i++) {
      result += (long) c[i] * Math.pow(idx, i);
    }
    return result;
  }
}
