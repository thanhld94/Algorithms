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
  	int count = 0;
  	while (n != 0) {
  		if ((n & 1) != 0) {
  			count++;
  		}
  		n >>= 1;
  	}
  	output.println(count);
  }
}
