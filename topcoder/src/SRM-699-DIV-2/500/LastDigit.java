import java.util.*;

public class LastDigit {
  
  public long findX(long S) {
    long left = 0L;
    long right = S;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long s = sum(mid);
      if (s == S) {
        return mid;
      }
      if (s > S) { 
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  private long sum(long s) {
    long result = 0;
    while (s != 0) {
      result += s;
      s /= 10;
    }
    return result;
  }
}
