import java.util.*;

public class BearNSWE {
  
  public double totalDistance(int[] a, String dir) {
    double total = 0.0;
    int x = 0;
    int y = 0;
    
    for (int i = 0; i < dir.length(); i++) {
      char letter = dir.charAt(i);
      if (letter == 'N') y += a[i];
      else if (letter == 'S') y -= a[i];
      else if (letter == 'E') x += a[i];
      else 
        x -= a[i];

      total += a[i];
    }

    total += Math.sqrt((1.0) * x * x + y * y);
    return total;
  }

}
