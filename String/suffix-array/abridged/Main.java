import java.util.Arrays;
import java.util.Scanner;

public class Main {
  
  private int n;
  private int[][] p;
  private Entry[] l;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    Main sol = new Main();
    for (int i = 0; i < t; i++) {
      int x = input.nextInt();
      String s = input.next();
      sol.solve(s);
    }
  }

  public void solve(String s) {
    int n = s.length();
    int maxLog = (int) (Math.log(n) / Math.log(2));

    p = new int[n][maxLog + 1];
    l = new Entry[n];
    
    for (int i = 0; i < n; i++) {
      p[i][0] = s.charAt(i) - 'a';
    }

    for (int step = 1, jump = 1; jump * 2 < n; step++, jump *= 2) {
      for (int i = 0; i < n; i++) {
        l[i] = new Entry();
        l[i].first = p[i][step - 1];
        l[i].second = (i + jump < n) ? p[i + jump][step - 1] : p[i + jump - n][step - 1];
        l[i].idx = i;
      }

      Arrays.sort(l);
      for (int i = 0; i < n; i++) {
        if (i > 0 && l[i].first == l[i - 1].first && l[i].second == l[i - 1].second) {
          p[l[i].idx][step] = p[l[i - 1].idx][step];
        } else {
          p[l[i].idx][step] = i;
        }
      }
    }
    
    int result = 0;
    for (int i = 1; i < n; i++) {
      if (p[i][maxLog] < p[result][maxLog]) {
        result = i;
      }
    }
    System.out.println(result);
  }

  private class Entry implements Comparable<Entry> {
    private int first;
    private int second;
    private int idx;

    @Override public int compareTo(Entry other) {
      if (first == other.first) {
        return second - other.second;
      }
      return first - other.first;
    }
  }
}
