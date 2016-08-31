/*
ID: thanhld1
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;

public class milk {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("milk.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
    milk sol = new milk();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int total = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Farmer[] farmers = new Farmer[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(input.readLine());
      int cost = Integer.parseInt(st.nextToken());
      int amount = Integer.parseInt(st.nextToken());
      farmers[i] = new Farmer(amount, cost);
    }

    Arrays.sort(farmers);
    int totalCost = 0;
    for (Farmer farmer : farmers) {
      int amount = Math.min(total, farmer.amount);
      totalCost += amount * farmer.cost;
      total -= amount;
      if (total == 0) {
        break;
      }
    }
    output.println(totalCost);
  }
  
  private class Farmer implements Comparable <Farmer> {
    private int amount;
    private int cost;
    
    private Farmer(int amount, int cost) {
      this.amount = amount;
      this.cost = cost;
    }

    @Override public int compareTo(Farmer other) {
      return cost - other.cost;
    }
  }
}
