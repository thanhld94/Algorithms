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
  	char[] num1 = input.next().toCharArray();
  	char[] num2 = input.next().toCharArray();
  	int[] result = new int[num1.length];
  	
  	for (int i = result.length - 1; i >= 0; i--) {
  		result[i] = (num1[i] - '0') ^ (num2[i] - '0');
  	}
  	for (int digit : result) {
  		output.print(digit);
  	}
  	output.println();
  }
}
