import java.util.*;

public class TriangleMaking {
  
  public int maxPerimeter(int a, int b, int c) {
    int[] edges = new int[3];
    edges[0] = a;
    edges[1] = b;
    edges[2] = c;
    Arrays.sort(edges);
    while (edges[0] + edges[1] <= edges[2]) {
      edges[2]--;
    }
    int result = 0;
    for (int val : edges) {
      result += val;
    }
    return result;
  }

}
