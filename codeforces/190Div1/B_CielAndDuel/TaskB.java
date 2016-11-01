import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    List<Integer> attacks = new ArrayList<Integer>();
    List<Integer> defends = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      String position = input.next();
      int power = input.nextInt();
      if (position.equals("ATK")) 
        attacks.add(power);
      else
        defends.add(power);
    }
    Collections.sort(attacks);
    Collections.sort(defends);

    int[] cards = new int[m];
    for (int i = 0; i < m; i++) {
      cards[i] = input.nextInt();
    }
    Arrays.sort(cards);

    // Try to remove defenders first
    boolean[] used = new boolean[m];
    int defFirst = 0;
    int removedDef = 0;
    for (int defend : defends) {
      for (int idx = 0;idx < m; idx++) {
        if (used[idx]) continue;
        if (cards[idx] > defend) {
          removedDef++;
          used[idx] = true;
          break;
        }
      }
    }
    // remove attackers
    int removedAtk = 0;
    for (int attack : attacks) {
      for (int idx = 0; idx < m; idx++) {
        if (used[idx]) continue;
        if (cards[idx] >= attack) {
          defFirst += (cards[idx] - attack);
          removedAtk++;
          used[idx] = true;
          break;
        }
      }
    }
    // attack directly
    if (removedAtk + removedDef - attacks.size() - defends.size() == 0) {
      for (int idx = 0; idx < m; idx++) {
        if (!used[idx]) defFirst += cards[idx];
      }
    }


    // Attack the worst attacking cards first
    Arrays.fill(used, false);
    int atkFirst = 0;
    removedAtk = 0;
    for (int attack : attacks) {
      for (int idx = m - 1; idx >= 0; idx--) {
        if (used[idx]) continue;
        if (cards[idx] >= attack) {
          removedAtk++;
          atkFirst += (cards[idx] - attack);
          used[idx] = true;
          break;
        }
      }
    }
    // Remove defender using the weakest possible cards
    removedDef = 0;
    for (int defend : defends) {
      for (int idx = 0; idx < m; idx++) {
        if (used[idx]) continue;
        if (cards[idx] > defend) {
          used[idx] = true;
          removedDef++;
          break;
        }
      }
    }
    // attack directly
    if (removedAtk + removedDef - attacks.size() - defends.size() == 0) {
      for (int idx = 0; idx < m; idx++) {
        if (!used[idx]) atkFirst += cards[idx];
      }
    }
    
    // Result
    output.println(Math.max(atkFirst, defFirst));
  }
}
