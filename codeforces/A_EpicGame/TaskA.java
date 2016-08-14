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
  	int[] a = new int[2];
  	a[0] = input.nextInt();
  	a[1] = input.nextInt();
  	int n = input.nextInt();
  	int flag = 1;
  	while (true) {
  		int take = gcd(n, a[1 - flag]);
  		if (n < take) {
  			output.println(flag);
  		  return;
      }
  		n -= take;
  		flag ^= 1;
  	}
  }

  int gcd(int a, int b) {
  	if (a % b == 0) return b;
  	return gcd(b, a%b);
  }
}
