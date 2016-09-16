import java.io.*;
import java.util.*;

public class Main {

  int n,q;
  int totalEntries;
  String[] cars = new String[10111];
  String[] result = new String[1111];
  Entry[] entries = new Entry[22555];

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
      n = Integer.parseInt(st.nextToken());
      int idx = 0;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(input.readLine());
        cars[i] = st.nextToken();
        int low = Integer.parseInt(st.nextToken());
        int high = Integer.parseInt(st.nextToken());
        entries[idx++] = new Entry(low, -1, i);
        entries[idx++] = new Entry(high, 1, i);
      }
  
      st = new StringTokenizer(input.readLine());
      q = Integer.parseInt(st.nextToken());
      for (int i = 0; i < q; i++) {
        st = new StringTokenizer(input.readLine());
        int val = Integer.parseInt(st.nextToken());
        entries[idx++] = new Entry(val, 0, i);
      }
      totalEntries = idx;
      getResult();
      for (int i = 0; i < q; i++) {
        output.println(result[i]);
      }
      if (t < test - 1)
        output.println();
    }
  }

  private void getResult() {
    Arrays.sort(entries, 0, totalEntries);
    Set<String> set = new HashSet<String>();
    for (int i = 0; i < totalEntries; i++) {
      Entry entry = entries[i];
      //String name = (entry.type == 0) ? "query" : cars[entry.idx];
      //System.out.println(entry.value + " " + entry.type + " " + entry.idx + " -> " + name);
      if (entry.type == -1) {
        set.add(cars[entry.idx]);
      } else if (entry.type == 1) {
        set.remove(cars[entry.idx]);
      } else {
        if (set.size() != 1) {
          result[entry.idx] = "UNDETERMINED";
          continue;
        }
        for (String car : set)
          result[entry.idx] = car;
      }
    }
  }

  private class Entry implements Comparable<Entry> {
    private int value;
    private int type;
    private int idx;

    private Entry(int value, int type, int idx) {
      this.value = value;
      this.type = type;
      this.idx = idx;
    }

    @Override public int compareTo(Entry other) {
      if (value == other.value) {
        return type - other.type;
      }
      return value - other.value;
    }
  }
}
