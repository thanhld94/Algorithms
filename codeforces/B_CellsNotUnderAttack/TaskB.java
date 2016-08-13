import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB{
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int m = input.nextInt();
  	boolean[] row = new boolean[n];
  	boolean[] col = new boolean[n];
  	int countRow = n;
  	int countCol = n;
  	for (int i = 0; i < m; i++) {
  		int x = input.nextInt() - 1;
  		int y = input.nextInt() - 1;
  		if (!row[x]) countRow--;
  		if (!col[y]) countCol--;
  		row[x] = true;
  		col[y] = true;
  		long result = 1L * countRow * countCol;
  		output.print(result + " ");
  	}
  	output.println();
  }
}
