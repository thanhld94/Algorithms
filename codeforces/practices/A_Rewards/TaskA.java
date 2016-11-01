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
  	int cups = 0;
  	int medals = 0;
  	for (int i = 0; i < 3; i++) {
  		cups += input.nextInt();
  	}
  	for (int i = 0; i < 3; i++) {
  		medals += input.nextInt();
  	}
  	int n = input.nextInt();

  	int selves = cups / 5 + medals / 10;
  	if (cups % 5 != 0) {
  		selves++;
  	}
  	if (medals % 10 != 0) {
  		selves++;
  	}

  	if (selves > n) {
  		output.println("NO");
  	} else {
  		output.println("YES");
  	}
  }
}
