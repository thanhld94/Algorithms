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
  	int[] count = new int[26];
  	for (int i = 0; i < 2; i++) {
  		String s = input.next();
  		for (int j = 0; j < s.length(); j++) {
  			count[s.charAt(j) - 'A']++;
  		}
  	}
  	String suffled = input.next();
  	for (int j = 0; j < suffled.length(); j++) {
  		count[suffled.charAt(j) - 'A']--;
  		if (count[suffled.charAt(j) - 'A'] < 0) {
  			output.println("NO");
  			return;
  		}
  	}

  	for (int cnt : count) {
  		if (cnt > 0) {
  			output.println("NO");
  			return;
  		}
  	}
  	output.println("YES");
  }
}
