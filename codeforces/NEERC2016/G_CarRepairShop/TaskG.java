import java.io.PrintWriter;
import java.util.*;

public class TaskG {
  public static void main(String[] args) {
    TaskG tG = new TaskG();
    PrintWriter pw = new PrintWriter(System.out);
    tG.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    List<Interval> intervals = new ArrayList<Interval>();
    for (int i = 0; i < n; i++) {
      int s = input.nextInt();
      int d = input.nextInt();
      int e = s + d - 1;
      boolean check = true;
      Collections.sort(intervals);

      // check if the original spot is valid
      for (Interval interval : intervals) {
        if (intersect(s, e, interval.begin, interval.end)) {
          check = false;
          break;
        }
      }

      // if original spot is valid
      if (check) {
        output.println(s + " " + e);
        intervals.add(new Interval(s,e));
        continue;
      }

      // check the possible spot
      int current = 1;
      for (Interval interval : intervals) {
        int end = current + d - 1;
        // if the current gap fits
        if (!intersect(current, end, interval.begin, interval.end)) {
          intervals.add(new Interval(current, end));
          output.println(current + " " + end);
          check = true;
          break;
        }
        current = interval.end + 1;
      }

      // outer left
      if (!check) {
        output.println(current + " " + (current + d - 1));
        intervals.add(new Interval(current, current + d - 1));
      }
    }
  }

  private boolean intersect(int s1, int e1, int s2, int e2) {
    if (s1 > s2) return intersect(s2, e2, s1, e1);
    return (e1 >= s2);
  }

  private class Interval implements Comparable<Interval> {
    private int begin;
    private int end;

    private Interval(int begin, int end) {
      this.begin = begin;
      this.end = end;
    }

    @Override public int compareTo(Interval other) {
      if (begin != other.begin) 
        return begin - other.begin;
      return end - other.end;
    }
  }
}
