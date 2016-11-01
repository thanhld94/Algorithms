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
  	int error1 = 0;
  	for (int i = 0; i < n; i++) {
  		error1 ^= input.nextInt();
  	}
  	int error2 = 0;
  	for (int i = 0; i < n - 1; i++) {
  		int error = input.nextInt();
  		error1 ^= error;
  		error2 ^= error;
  	}

  	for (int i = 0; i < n - 2; i++) {
  		error2 ^= input.nextInt();
  	}
  	output.println(error1);
  	output.println(error2);
  }
}
