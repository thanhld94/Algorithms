import java.util.*;

public class DivisibleSetDiv2 {
  
  public String isPossible(int[] b) {
    double sum = 0.0;
    for (int val : b) {
      sum += (1.0) / val;
    }
    String result = (sum <= 1.0 + 1e-7) ? "Possible" : "Impossible";
    return result;
  }

}
