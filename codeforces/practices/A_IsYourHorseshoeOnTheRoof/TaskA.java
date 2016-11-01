import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	HashMap <Integer, Boolean> map = new HashMap <Integer, Boolean>();
  	int count = 0;
  	for (int i = 0; i < 4; i++) {
  		int color = input.nextInt();
  		if (!map.containsKey(color)) {
  			count++;
  			map.put(color, true);
  		}
  	}
  	output.println(4 - count);
  }
}
