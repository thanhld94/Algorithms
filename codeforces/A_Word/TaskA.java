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
  	String text = input.next();
  	int countLower = 0;
  	for (int i = 0; i < text.length(); i++) {
  		if ('a' <= text.charAt(i) && text.charAt(i) <= 'z') {
  			countLower++;
  		}
  	}

  	if ((text.length() - countLower) > (text.length() / 2)) {
  		output.println(text.toUpperCase());
  	} else {
  		output.println(text.toLowerCase());
  	}
  }
}
