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
  	String current = input.next();
  	String unlock = input.next();
  	int result = 0;
  	for (int i = 0; i < n; i++) {
  		int currentDigit = current.charAt(i) - '0';
  		int unlockDigit = unlock.charAt(i) - '0';
  		result += Math.min(Math.abs(currentDigit - unlockDigit), 10 - Math.abs(currentDigit - unlockDigit));
  	}
  	output.println(result);
  }
}
