import java.io.PrintWriter;
import java.util.*;

public class TaskC {

  private static final double EPSILON = 0.00000001;

  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int w = input.nextInt();
    int v = input.nextInt();
    int u = input.nextInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = input.nextInt();
      int y = input.nextInt();
      points[i] = new Point(x,y);
    }
    if (inTime(0, points, u, v)) {
      output.println(1.0 * w / u);
      return;
    }
    double startTime = binarySearch(points, u, v, w);
    output.println(startTime + 1.0 * w / u);
  }

  private double binarySearch(Point[] points, int u, int v, int w) {
    int maxX = Integer.MIN_VALUE;
    for (Point point : points) {
      maxX = Math.max(maxX, point.x);
    }

    double l = 0.0;
    double r = 1.0 * maxX / v;
    double result = r;
    while (l <= r - EPSILON) {
      double mid = (l + r) / 2;
      //System.out.println("l = " + l + " r = " + r + " -> mid = " + mid);
      if (inTime(mid, points, u, v)) {
        result = mid;
        r = mid - EPSILON;
      } else {
        l = mid + EPSILON;
      }
    }
    return result;
  }

  private boolean inTime(double startTime, Point[] points, int u, int v) {
    int n = points.length;
    int below = 0;
    for (Point point : points) {
      double busTime = 1.0 * point.x / v;
      if ((busTime - startTime) * u < point.y - EPSILON) { // arrive after the bus
        below++;
      } 
    }
    if (below == 0 || below == n) {
      return true;
    } 
    return false;
  }

  private class Point {
    private int x;
    private int y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
