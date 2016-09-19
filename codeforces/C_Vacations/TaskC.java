import java.io.PrintWriter;
import java.util.*;

public class TaskC {

  private static final int INF = 100000;

  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] status = new int[n];
    for (int i = 0; i < n; i++) {
      status[i] = input.nextInt();
    }

    int[][] dp = new int[n][3];
    for (int i = 0; i < n; i++) {
      dp[i][0] = dp[i][1] = dp[i][2] = -1;
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) {
      result = Math.min(result, getResult(n - 1, i, status, dp));
    }
    output.println(result);
  }

  private int getResult(int day, int action, int[] status, int[][] dp) {
    if (dp[day][action] != -1) {
      return dp[day][action];
    }

    if (action != 0 && (status[day] & action) == 0) { //no available action
      dp[day][action] = INF;
      return dp[day][action];
    }

    if (day == 0) {
      dp[day][action] = 0;
      if (action == 0) {
        dp[day][action] = 1;
      }
      return dp[day][action];
    }

    dp[day][action] = Integer.MAX_VALUE; 
    for (int last = 0; last < 3; last++) {
      if ((last & action) == 0) { // valid move
        int result = getResult(day - 1, last, status, dp);
        if (action == 0) 
          result++;

        dp[day][action] = Math.min(dp[day][action], result);
      }
    }
    return dp[day][action];
  }
}
