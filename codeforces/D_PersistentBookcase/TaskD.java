import java.io.PrintWriter;
import java.util.Scanner;

public class TaskD{
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int m = input.nextInt();
  	int q = input.nextInt();
  	int[][] selves = new int[n + 1][q + 1];
  	int[] total = new int[q + 1];
  	for (int i = 1; i <= n; i++) {
  		selves[i][0] = 0;
  	}
  	for (int i = 1; i <= q; i++) {
  		int type = input.nextInt();
  		if (type < 4) {
  			for (int r = 1; r <= n; r++) {
  				selves[r][i] = selves[r][i - 1];
  			}
  		}
  		if (type == 1) {
  			int col = input.nextInt();
  			int row = input.nextInt();
  			selves[row][i] = selves[row][i - 1] + 1;
  			total[i] = total[i - 1] + 1;
  		} else if (type == 2) {
  			int col = input.nextInt();
  			int row = input.nextInt();
  			selves[row][i] = selves[row][i - 1] - 1;
  			total[i] = total[i - 1] - 1;
  		} else if (type == 3) {
  			int row = input.nextInt();
  			selves[row][i] = m - selves[row][i - 1];
  			total[i] = total[i - 1] + (selves[row][i] - selves[row][i - 1]);
  		} else {
  			int t = input.nextInt();
  			for (int r = 1; r <= n; r++) {
  				selves[r][i] = selves[r][t];
  			}
  			total[i] = total[t];
  		}
  		output.println(total[i]);
  	}
  }
}
