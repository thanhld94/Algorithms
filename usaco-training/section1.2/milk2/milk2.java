/*
ID: thanhld1
LANG: JAVA
TASK: milk2
*/

import java.util.*;
import java.io.*;

public class milk2 {

  public static void main(String[] args) throws IOException {
    milk2 sol = new milk2();
    sol.solve();
  }

  public void solve() throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("milk2.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    StringTokenizer st = new StringTokenizer(input.readLine());

    int n = Integer.parseInt(st.nextToken());
    Farmer[] farmers = new Farmer[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      int start = Integer.parseInt(st.nextToken());
      int finish = Integer.parseInt(st.nextToken());
      farmers[i] = new Farmer(start, finish);
    }
    
    Arrays.sort(farmers);
    int maxMilk = 0;
    int maxIdle = 0;
    int currentLength = farmers[0].finish - farmers[0].start;
    int currentLast = farmers[0].finish;
    for (int i = 1; i < n; i++) {
      if (farmers[i].start > currentLast) {
        maxMilk = Math.max(maxMilk, currentLength);
        maxIdle = Math.max(maxIdle, farmers[i].start - currentLast);
        currentLength = farmers[i].finish - farmers[i].start;
        currentLast = farmers[i].finish;
      } else {
        if (farmers[i].finish > currentLast) {
          currentLength += (farmers[i].finish - currentLast);
          currentLast = farmers[i].finish;
        }
      }
    }
    maxMilk = Math.max(maxMilk, currentLength);
    output.println(maxMilk + " " + maxIdle);
    output.close();
  }

  public class Farmer implements Comparable <Farmer> {
    private int start;
    private int finish;

    public Farmer(int start, int finish) {
      this.start = start;
      this.finish = finish;
    }

    @Override public int compareTo(Farmer other) {
      if (start == other.start) {
        return finish - other.finish;
      }
      return start - other.start;
    }
  }
}
