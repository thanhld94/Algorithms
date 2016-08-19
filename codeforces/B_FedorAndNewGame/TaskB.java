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
  	int k = input.nextInt();
  	int[] armies = new int[m + 1];
  	for (int i = 0; i <= m; i++) {
  		armies[i] = input.nextInt();
  	}

  	int count = 0;
  	for (int i = 0; i < m; i++) {
  		int delta = armies[i] ^= armies[m];
  		if (countOnes(delta) <= k) {
  			count++;
  		}
  	}
  	output.println(count);
  }

  private int countOnes(int x) {
  	int count = 0;
  	while (x != 0) {
  		if ((x & 1) != 0) {
  			count++;
  		}
  		x >>= 1;
  	}
  	return count;
  }
}
