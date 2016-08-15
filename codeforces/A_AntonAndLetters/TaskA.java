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
  	String letter = input.nextLine();
  	boolean[] appeared = new boolean[26];
  	for (int i = 0; i < letter.length(); i++) {
  		if ('a' <= letter.charAt(i) && letter.charAt(i) <= 'z') {
  			appeared[letter.charAt(i) - 'a'] = true;
  		}
  	}

  	int result = 0;
  	for (boolean app : appeared) {
  		if (app) {
  			result++;
  		}
  	}
  	output.println(result);
  }
}
