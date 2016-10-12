import java.util.*;

public class UpDownHiking {
  
  public int maxHeight(int N, int A, int B) {
    int result = 0;
    for (int i = N; i > 0; i--) {
      int h = Math.min(i * A, (N - i) * B);
      result = Math.max(result, h);
    }
    return result;
  }

}
