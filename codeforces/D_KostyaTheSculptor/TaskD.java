import java.io.PrintWriter;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int maxVal = 0;
    int idx1 = -1;
    int idx2 = -1;
    Map<Pair, Pair> map = new HashMap<Pair, Pair>();
    for (int i = 0; i < n; i++) {
      int[] length = new int[3];
      for (int j = 0; j < 3; j++) {
        length[j] = input.nextInt();
      }
      Arrays.sort(length);

      if (maxVal < length[0]) {
        maxVal = length[0];
        idx1 = i + 1;
        idx2 = -1;
      }

      // combining side (y,z)
      if (maxVal < get(map, length[0], length[1], length[2])) {
        maxVal = get(map, length[0], length[1], length[2]);
        idx1 = map.get(new Pair(length[1], length[2])).second + 1;
        idx2 = i + 1;
      }

      // combining side (x, z)
      if (maxVal < get(map, length[1], length[0], length[2])) {
        maxVal = get(map, length[1], length[0], length[2]);
        idx1 = map.get(new Pair(length[0], length[2])).second + 1;
        idx2 = i + 1;
      }

      // combining side (x, y)
      if (maxVal < get(map, length[2], length[0], length[1])) {
        maxVal = get(map, length[2], length[0], length[1]);
        idx1 = map.get(new Pair(length[0], length[1])).second + 1;
        idx2 = i + 1;
      }
      update(map, length[0], length[1], length[2], i);
      update(map, length[0], length[2], length[1], i);
      update(map, length[1], length[2], length[0], i);
    }
    if (idx2 == -1) {
      output.println(1);
      output.println(idx1);
    } else {
      output.println(2);
      output.println(idx1 + " " + idx2);
    }
  }

  private int get(Map<Pair, Pair> map, int x, int y, int z) {
    Pair surface = new Pair(y, z);
    if (map.containsKey(surface)) {
      int w = map.get(surface).first + x;
      return Math.min(w, Math.min(y, z));
    }
    return -1;
  }

  private void update(Map<Pair, Pair> map, int x, int y, int val, int idx) {
    Pair surface = new Pair(x, y);
    if (map.containsKey(surface)) {
      if (map.get(surface).first < val) {
        map.put(surface, new Pair(val, idx));
      }
      return;
    }
    map.put(surface, new Pair(val, idx));
  }

  private class Pair {
    private int first;
    private int second;

    private Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override public boolean equals(Object o) {
      if (!(o instanceof Pair)) return false;
      Pair other = (Pair)o;
      return first == other.first && second == other.second;
    }

    @Override public int hashCode() {
      return Objects.hash(first, second);
    }
  }
}
