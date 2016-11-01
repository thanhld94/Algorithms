import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC {
  
  public static void main(String[] args) {
    TaskC tc = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tc.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] costs = new int[n];
    for (int i = 0; i < n; i++) {
      costs[i] = input.nextInt();
    }
    
    String previous = input.next();
    String previousReverse = reverse(previous);
    long previousNotReverseCost = 0;
    long previousReverseCost = costs[0];
    long currentReverseCost = Long.MAX_VALUE;
    long currentNotReverseCost = Long.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      String current = input.next();
      String currentReverse = reverse(current);
      currentNotReverseCost = Long.MAX_VALUE;
      if (current.compareTo(previous) >= 0) {
        currentNotReverseCost = previousNotReverseCost;
      }
      if (current.compareTo(previousReverse) >= 0) {
        currentNotReverseCost = Math.min(currentNotReverseCost, previousReverseCost);
      }

      //reverse
      currentReverseCost = Long.MAX_VALUE;
      if (previousNotReverseCost < Long.MAX_VALUE && currentReverse.compareTo(previous) >= 0) {
        currentReverseCost = previousNotReverseCost + costs[i];
      }
      if (previousReverseCost < Long.MAX_VALUE && currentReverse.compareTo(previousReverse) >= 0) {
        currentReverseCost = Math.min(currentReverseCost, previousReverseCost + costs[i]);
      }
      if (currentReverseCost == Long.MAX_VALUE && currentNotReverseCost == Long.MAX_VALUE) {
        output.println(-1);
        return;
      }
      //output.println(previousReverseCost + " " + previousNotReverseCost + " " + currentReverseCost + " " + currentNotReverseCost);
      previous = current;
      previousReverse = currentReverse;
      previousReverseCost = currentReverseCost;
      previousNotReverseCost = currentNotReverseCost;
    }
    output.println(Math.min(currentReverseCost, currentNotReverseCost));
  }

  private String reverse(String original) {
    char[] cs = new char[original.length()];
    for (int i = 0; i < cs.length; i++) {
      cs[i] = original.charAt(cs.length - i - 1);
    }
    return new String(cs);
  }
}
