import java.util.Arrays;

public class SuffixArray {
  private int[][] p;
  private Entry[] l;
  private int len;

  public static void main(String[] args) {
    String s = args[0];
    SuffixArray sa = new SuffixArray();
    sa.initSA(s);
  }

  public void initSA(String s) {
    int len = s.length();
    int maxLog = (int) (Math.log(len) / Math.log(2));
    p = new int[len][maxLog + 1];
    l = new Entry[len];

    for (int i = 0; i < len; i++) {
      p[i][0] = s.charAt(i) - 'a'; // Assume s contains only lowercase characters
    }

    for (int step = 1, jump = 1; jump * 2 < len; step++, jump *= 2) {
      for (int i = 0; i < len; i++) {
        l[i] = new Entry();
        l[i].first = p[i][step - 1];
        l[i].second = (i + jump < len) ? p[i + step][step - 1] : -1;
        l[i].idx = i;
      }

      Arrays.sort(l);
      for (int i = 0; i < len; i++) {
        p[l[i].idx][step] = (i > 0 && l[i].first == l[i - 1].first && l[i].second == l[i - 1].second) ?
          p[l[i - 1].idx][step] : i;
      }
    }

    for (int i = 0; i < len; i++) {
      System.out.print(p[i][maxLog] + " ");
    }
    System.out.println();
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
