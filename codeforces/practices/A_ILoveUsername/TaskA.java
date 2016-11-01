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
  	int max = input.nextInt();
  	int min = max;
  	int count = 0;
  	
  	for (int i = 1; i < n; i++) {
  		int point = input.nextInt();
  		if (point > max || point < min) {
  			count++;
  		}
  		max = Math.max(max, point);
  		min = Math.min(min, point);
  	}
  	output.println(count);
  }
}
