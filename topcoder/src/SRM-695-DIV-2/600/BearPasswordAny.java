import java.util.*;

public class BearPasswordAny {
  
  public String findPassword(int[] x) {
    char[] letters = new char[x.length];
    char flag = 'a';
    int length = 0;
    letters[0] = flag;

    for (int i = 1; i < x.length; i++) {
      if (x[length + 1] == 0) {
        flag = (flag == 'a') ? 'b' : 'a';
        for (int l = 0; l <= length; l++) {
          x[l] -= (length - l + 1);
          if (x[l] < 0) {
            return "";
          }
        }
        length = 0;
        letters[i] = flag;
      } else {
        letters[i] = flag;
        length++;
      }
    }

    for (int l = 0; l <= length; l++) {
      x[l] -= (length - l + 1);
      if (x[l] < 0) return "";
    }

    for (int val : x) {
      if (val > 0) return "";
    }
    
    return new String(letters);
  }

}
