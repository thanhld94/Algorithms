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
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int test = 0;
    while (n != 0 || q != 0) {
      int[] marbles = new int[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(input.readLine());
        marbles[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(marbles);
      Map <Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < n; i++) {
        if (!map.containsKey(marbles[i])) {
          map.put(marbles[i], i + 1);
        }
      }

      output.printf("CASE# %d:\n", ++test);
      for (int i = 0; i < q; i++) {
        st = new StringTokenizer(input.readLine());
        int query = Integer.parseInt(st.nextToken());
        if (map.containsKey(query)) {
          output.printf("%d found at %d\n", query, map.get(query));
        } else {
          output.printf("%d not found\n", query);
        }
      }

      st = new StringTokenizer(input.readLine());
      n = Integer.parseInt(st.nextToken());
      q = Integer.parseInt(st.nextToken());
    }
  }
}
