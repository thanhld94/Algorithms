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
  	if (n >= 0) {
  		output.println(n);
  	} else {
  		n *= -1;
  		int lastDigit = n % 10;
  		n /= 10;
  		int nextToLast = n % 10;
  		n /= 10;
  		n = n * 10 + Math.min(lastDigit, nextToLast);
  		output.println(-n);
  	}
  }
}
