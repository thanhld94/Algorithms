import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  int n, m, k, x, s;
  int[] firstTime, firstCost;
  int[] secondCount, secondCost;

  public void solve(Scanner input, PrintWriter output) {
    n = input.nextInt();
    m = input.nextInt();
    k = input.nextInt();
    x = input.nextInt();
    s = input.nextInt();

    firstTime = new int[m];
    firstCost = new int[m];
    for (int i = 0; i < m; i++) 
      firstTime[i] = input.nextInt();
    for (int i = 0; i < m; i++)
      firstCost[i] = input.nextInt();

    secondCount = new int[k];
    secondCost = new int[k];
    for (int i = 0; i < k; i++)
      secondCount[i] = input.nextInt();
    for (int i = 0; i < k; i++) 
      secondCost[i] = input.nextInt();
    process(output);
  }

  private void process(PrintWriter out) {
    long minTime = 1L * n * x;
    {
      // doing only spell2;
      int spell2 = findMax(s);
      if (spell2 >= 0) 
        minTime -= 1L * secondCount[spell2] * x;
    }
    {
      // trying do spell 1 and then a spell 2
      for (int i = 0; i < m; i++) {
        long newTime = 1L * n * firstTime[i];
        int mana = s - firstCost[i];
        if (mana < 0) continue;
        int res = findMax(mana); 
        if (res >= 0) {
          newTime -= 1L * secondCount[res] * firstTime[i];
        }
        minTime = Math.min(minTime, newTime);
      }
    }
    out.println(minTime);
  }

  private int findMax(int mana) {
    int l = 0;
    int r = k - 1;
    int res = -1;
    while (l <= r) {
      int mid = l + (r - l)/2;
      if (secondCost[mid] <= mana) {
        res = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return res;
  }
}
