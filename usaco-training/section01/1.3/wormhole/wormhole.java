/*
ID: thanhld1
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;

public class wormhole {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("wormhole.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
    wormhole sol = new wormhole();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());

    Point[] holes = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      holes[i] = new Point(x,y);
    }
    
    int[] goingOut = new int[n];
    for (int i = 0; i < n; i++) {
      int min = -1;
      for (int j = 0; j < n; j++) {
        if (holes[i].y == holes[j].y && holes[i].x < holes[j].x) {
          min = (min == -1 || holes[j].x < holes[min].x) ? j : min;
        }
      }
      goingOut[i] = min;
    }

    int[] goingIn = new int[n];
    for (int i = 0; i < n; i++) {
      goingIn[i] = -1;
    }
    output.println(generate(goingIn, goingOut, n));
  }

  private int generate(int[] goingIn, int[] goingOut, int n) {
    int i;
    for (i = 0; i < n; i++) {
      if (goingIn[i] == -1) {
        break;
      }
    }

    if (i >= n) {
      if (hasCycle(goingIn, goingOut, n)) {
        return 1;
      }
      return 0;
    }

    int total = 0;
    for (int j = i + 1; j < n; j++) {
      if (goingIn[j] == -1) {
        goingIn[j] = i;
        goingIn[i] = j;
        total += generate(goingIn, goingOut, n);
        goingIn[i] = goingIn[j] = -1;
      }
    }
    return total;
  }

  private boolean hasCycle(int[] goingIn, int[] goingOut, int n) {
    for (int start = 0; start < n; start++) {
      int current = start;
      for (int step = 0; step < n; step++) {
        if (goingOut[current] == -1) {
          current = -1;
          break;
        }
        current = goingIn[goingOut[current]];
      }
      if (current != -1) return true;
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
