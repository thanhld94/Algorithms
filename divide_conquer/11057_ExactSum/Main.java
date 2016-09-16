import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    String line = input.readLine();
    while (line != null) {
      StringTokenizer st = new StringTokenizer(line);
      int n = Integer.parseInt(st.nextToken());
      Map <Integer, Integer> map = new HashMap<Integer, Integer>();
      st = new StringTokenizer(input.readLine());
      for (int i = 0; i < n; i++) {
        int val = Integer.parseInt(st.nextToken());
        if (map.containsKey(val)) {
          map.put(val, map.get(val) + 1);
        } else {
          map.put(val, 1);
        }
      }

      st = new StringTokenizer(input.readLine());
      int target = Integer.parseInt(st.nextToken());
      int lres = -1;
      int hres = -1;
      for (Entry <Integer, Integer> entry : map.entrySet()) {
        int rem = target - entry.getKey();

        if (map.containsKey(rem)) {
          if (rem != entry.getKey() || entry.getValue() > 1) {
            if (lres == -1 || hres - lres > Math.abs(entry.getKey() - rem)) {
              lres = Math.min(entry.getKey(), rem);
              hres = Math.max(entry.getKey(), rem);
            }
          }
        }
      }

      output.printf("Peter should buy books whose prices are %d and %d.\n", lres, hres);
      output.println();
      line = input.readLine();
      if (line == null) {
        return;
      }
      line = input.readLine();
    }
  }
}
