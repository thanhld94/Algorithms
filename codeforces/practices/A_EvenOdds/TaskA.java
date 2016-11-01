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
  	long n = input.nextLong();
  	long k = input.nextLong();
  	long half = n/2;
  	if (n % 2 == 1) {
  		half++;
  	}

  	if (k <= half) { // kth odd number
  		output.println(2L * (k - 1) + 1);
  	} else { // (k - n/2)th even number
  		k -= half;
  		output.println(2L * k);
  	}
  }
}
