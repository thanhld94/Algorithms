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
  	int[] count = new int[2];
  	int[] res = new int[2];
  	for (int i = 1; i <= n; i++) {
  		int num = input.nextInt();
  		count[num % 2]++;
  		if (count[num % 2] == 1) {
  			res[num % 2] = i;
  		}
  	}
  	if (count[0] == 1) {
  		output.println(res[0]);
  	} else {
  		output.println(res[1]);
  	}
  }
}
