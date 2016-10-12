import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  int n, m, k;
  int max;
  List<List<Integer>> list0;
  List<List<Integer>> list1;
  int[] x;
  int[] y;
  long[] time;

  public void solve(Scanner input, PrintWriter output) {
    n = input.nextInt();
    m = input.nextInt();
    max = Math.max(n, m);

    list0 = new ArrayList<List<Integer>>();
    list1 = new ArrayList<List<Integer>>();
    for (int i = 0; i <= 2 * max; i++) {
      list0.add(new ArrayList<Integer>());
      list1.add(new ArrayList<Integer>());
    }

    k = input.nextInt();
    x = new int[k];
    y = new int[k];
    time = new long[k];
    Arrays.fill(time, -1);
    // reading input and putting sensors into the two lists
    for (int i = 0; i < k; i++) {
      x[i] = input.nextInt();
      y[i] = input.nextInt();
      list0.get(m + x[i] - y[i]).add(i);
      list1.get(x[i] + y[i]).add(i);
    }

    // simulating the reflecting process
    Point current = new Point(0, 0);
    int dir = 0;
    long currentTime = 0L;
    
    for (int i = 0; i < 4 * max; i++) { //bouncing only within these time
      Point next = getEnd(current, dir);
      if (current.x - current.y == next.x - next.y) { // type 0
        for (int idx : list0.get(m + current.x - current.y)) {
          if (time[idx] != -1) {
            continue;
          }
          time[idx] = currentTime + Math.abs(x[idx] - current.x);
        }
      } else {
        for (int idx : list1.get(current.x + current.y)) {
          if (time[idx] != -1) {
            continue;
          }
          time[idx] = currentTime + Math.abs(x[idx] - current.x);
        }
      }
      
      if (isCorner(next)) {
        break;
      }
      currentTime += Math.abs(current.x - next.x);
      current = next;
      dir = nextDir(next, dir);
    }

    // printing output
    for (long val : time) {
      output.println(val);
    }
  }
  
  private static final int[] dx = {1, 1, -1, -1};
  private static final int[] dy = {1, -1, -1, 1};

  private Point getEnd(Point current, int dir) {
    int delta = 0;
    if (dir == 0) delta = Math.min(n - current.x, m - current.y);
    else if (dir == 1) delta = Math.min(n - current.x, current.y);
    else if (dir == 2) delta = Math.min(current.x, current.y);
    else delta = Math.min(current.x, m - current.y); // dir == 3

    Point next = new Point(current.x + dx[dir] * delta, current.y + dy[dir] * delta);
    return next;
  }

  private int nextDir(Point next, int dir) {
    if (dir == 0) {
      return (next.y == m) ? 1 : 3;
    } else if (dir == 1) {
      return (next.x == n) ? 2 : 0;
    } else if (dir == 2) {
      return (next.y == 0) ? 3 : 1;
    }
    return (next.x == 0) ? 0 : 2;
  }

  private boolean isCorner(Point p) {
    if (p.x == 0 && p.y == 0) return true;
    if (p.x == 0 && p.y == m) return true;
    if (p.x == n && p.y == 0) return true;
    if (p.x == n && p.y == m) return true;
    return false;
  }

  private class Point {
    private int x;
    private int y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
