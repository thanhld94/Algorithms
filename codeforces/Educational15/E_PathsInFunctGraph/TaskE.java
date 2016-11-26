import java.io.PrintWriter;
import java.util.Scanner;

public class TaskE{
  public static void main(String[] args) {
    TaskE tE = new TaskE();
    PrintWriter pw = new PrintWriter(System.out);
    tE.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	long k = input.nextLong();
  	int[][] parent = new int[n][35];
    for (int i = 0; i < n; i++) {
      parent[i][0] = input.nextInt();
    }

    long[][] sum = new long[n][35];
  	long[][] min = new long[n][35];
  	for (int i = 0; i < n; i++) {
      sum[i][0] = input.nextLong();
      min[i][0] = sum[i][0];
  	}

    for (int i = 1; i < 35; i++) {
      for (int node = 0; node < n; node++) {
        parent[node][i] = parent[parent[node][i - 1]][i - 1];
        sum[node][i] = sum[node][i - 1] + sum[parent[node][i - 1]][i - 1];
        min[node][i] = Math.min(min[node][i - 1], min[parent[node][i - 1]][i - 1]);
      }
    }

    for (int i = 0; i < n; i++) {
      long minResult = Long.MAX_VALUE;
      long totalDist = 0;
      int p = i;
      for (int j = 0; j < 35; j++) {
        if ((k & (1L << j)) != 0) {
          minResult = Math.min(minResult, min[p][j]);
          totalDist += sum[p][j];
          p = parent[p][j];
        }
      }
      output.println(totalDist + " " + minResult);
    }
  }
}
