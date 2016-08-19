import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int[] candidate = new int[n];
  	int m = input.nextInt();
  	for (int i = 0; i < m; i++) {
  		int winner = 1;
  		int max = -1;
  		for (int j = 0; j < n; j++) {
  			int votes = input.nextInt();
  			if (max < votes) {
  				max = votes;
  				winner = j;
  			}
  		}
  		candidate[winner]++;
  	}
  	int winner = 0;
  	for (int i = 1; i < n; i++) {
  		if (candidate[i] > candidate[winner]) {
  			winner = i;
  		}
  	}
  	output.println(winner + 1);
  }
}
