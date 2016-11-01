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
  	int[] a = new int[n];
  	int result = 0;
  	for (int i = 0; i < n; i++) {
  		a[i] = input.nextInt();
  		result += a[i];
  	}

  	int count = result;
  	int current = result;
  	for (int i = 0; i < n; i++) {
  		int delta = (a[i] == 0) ? 1 : -1;
  		count = Math.max(count + delta, result);
  		current = Math.max(count, current);
  	}
  	if (current == result) {
  		output.println(result - 1);
  	} else {
  		output.println(current);
  	}
  }
}
