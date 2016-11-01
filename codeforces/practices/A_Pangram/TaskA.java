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
  	int len = input.nextInt();
  	String s = input.next().toLowerCase();
  	boolean[] apps = new boolean[26];
  	for (int i = 0; i < len; i++) {
  		apps[s.charAt(i) - 'a'] = true;
  	}

  	for (boolean app : apps) {
  		if (!app) {
  			output.println("NO");
  			return;
  		}
  	}
  	output.println("YES");
  }
}
