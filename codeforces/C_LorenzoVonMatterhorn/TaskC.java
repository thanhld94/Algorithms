import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int q = input.nextInt();
    Map <Long, Long> map = new HashMap<Long, Long>();
    while (q-- > 0) {
      int query = input.nextInt();
      long u = input.nextLong();
      long v = input.nextLong();
      long lca = getLca(u, v);
      //System.out.println("Lca = " + lca);
      if (query == 1) { // add query 
        long w = input.nextLong();
        while (u != lca) {
          addValue(map, u, w);
          //System.out.println("add to " + u);
          u /= 2;
        }
        while (v != lca) {
          addValue(map, v, w);
          //System.out.println("add to " + v);
          v /= 2;
        }
      } else { // get sum query
        long result = 0L;
        while (u != lca) {
          result += getValue(map, u);
          //System.out.println("get from " + u + " -> " + result);
          u /= 2;
        }
        while (v != lca) {
          result += getValue(map, v);
          //System.out.println("get from " + v + " -> " + result);
          v /= 2;
        }
        output.println(result);
      }
    }
  }

  private void addValue(Map <Long, Long> map, long u, long w) {
    if (!map.containsKey(u)) {
      map.put(u, w);
    } else {
      map.put(u, map.get(u) + w);
    }
  }

  private long getValue(Map <Long, Long> map, long u) {
    if (!map.containsKey(u)) {
      return 0L;
    }
    return map.get(u);
  }
  
  private long getLca(long u, long v) {
    if (depth(u) > depth(v)) {
      return getLca(v, u);
    }
    while (depth(u) < depth(v)) {
      v /= 2;
    }
    if (u == v) {
      return u;
    }
    return getLca(u/2, v/2);
  }

  private int depth(long u) {
    return (int) (Math.log(u) / Math.log(2));
  }
}
