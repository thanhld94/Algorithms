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
  	long d = input.nextLong();
  	long k = input.nextLong();
  	long a = input.nextLong();
  	long b = input.nextLong();
  	long t = input.nextLong();
  	if (b <= a) {
  		output.println(b * d);
  		return;
  	} 
  	if (d <= k) {
  		output.println(Math.min(b * d, a * d));
  		return;
  	}
  	d -= k;
  	long time = a * k;
  	long rem = d % k;
  	if (k * a + t >= b * k) {
  		output.println(a * k + b * d);
  		return;
  	}
  	time += ((a * k + t) * (d / k));
  	long remainTime = (rem * a + t < b * rem) ? rem * a + t : b * rem;
  	output.println(time + remainTime);
  }
}
