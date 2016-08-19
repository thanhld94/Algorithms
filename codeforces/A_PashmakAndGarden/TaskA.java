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
  	int x1 = input.nextInt();
  	int y1 = input.nextInt();
  	int x2 = input.nextInt();
  	int y2 = input.nextInt();	
  	if (x1 == x2) {
  		int x = x1 + Math.abs(y1 - y2);
  		output.println(x + " " + y1 + " " + x + " " + y2);
  	} else if (y1 == y2) {
  		int y = y1 + Math.abs(x1 - x2);
  		output.println(x1 + " " + y + " " + x2 + " " + y);
  	} else {
  		int lenx = Math.abs(x1 - x2);
  		int leny = Math.abs(y1 - y2);
  		if (lenx != leny) {
  			output.println(-1);
  		} else {
  			output.println(x1 + " " + y2 + " " + x2 + " " + y1);
  		}
  	}
  }
}
