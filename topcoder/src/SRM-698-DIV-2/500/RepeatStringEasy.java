import java.util.*;

public class RepeatStringEasy
{
	public int maximalLength(String s)
	{
    int result = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = i; j < s.length(); j++) {
        int[][] f = new int[s.length()][s.length()];
        for (int[] row : f) {
          Arrays.fill(row, -1);
        }
        int c = count(s, j - 1, s.length() - 1, j - 1, s.length() - 1, f);
        result = Math.max(result, c * 2);
      }
    }
    return result;
	}

  private int count(String s, int f1, int f2, int idx1, int idx2, int[][] f) {
    if (idx1 < 0 || idx2 <= f1) {
      return 0;
    }
    if (f[idx1][idx2] != -1) {
      return f[idx1][idx2];
    }

    int result = count(s, f1, f2, idx1 - 1, idx2 - 1, f);
    if (s.charAt(idx1) == s.charAt(idx2)) {
      result++;
    }
  
    int prev = Math.max(count(s, f1, f2, idx1 - 1, idx2, f), count(s, f1, f2, idx1, idx2 - 1, f));
    result = Math.max(result, prev);
    f[idx1][idx2] = result;
    return result;
  }
}

