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
  	/*
  		At remain x
  		need x tries to find correct key
  		need x-1 press for reseting the previous correct
  		-> Sum = x + x-1 for x = n -> 1
  	*/


  	int n = input.nextInt();
  	int result = 0;
  	for (int i = n; i >= 1; i--) {
  		result += (i - 1) * (n - i) + i;
  	} 
  	output.println(result);
  }
}
