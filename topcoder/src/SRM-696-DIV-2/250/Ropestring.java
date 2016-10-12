import java.util.*;

public class Ropestring {
  
  public String makerope(String s) {
    List<Integer> even = new ArrayList<Integer>();
    List<Integer> odd = new ArrayList<Integer>();

    int current = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '-') {
        current++;
      } else {
        if (current > 0) {
          if (current % 2 == 0) {
            even.add(current);
          } else {
            odd.add(current);
          }
        }
        current = 0;
      }
    }

    if (current > 0) {
      if (current % 2 == 0) even.add(current);
      else odd.add(current);
    }
    Collections.sort(odd, Collections.reverseOrder());
    Collections.sort(even, Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    int len = 0;
    for (int val : even) {
      for (int i = 0; i < val; i++) {
        sb.append('-');
        len++;
      }
      if (len < s.length()) {
        len++;
        sb.append('.');
      }
    }

    for (int val : odd) {
      for (int i = 0; i < val; i++) {
        sb.append('-');
        len++;
      }
      if (len < s.length()) {
        sb.append('.');
        len++;
      }
    }

    while (len < s.length()) {
      len++;
      sb.append('.');
    }
    return sb.toString();
  }
}
