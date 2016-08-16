import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{

	private static final int NUMBER_OF_PLAYERS = 5;

  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int sum = 0;
  	int min = Integer.MAX_VALUE;
  	for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
  		int current = input.nextInt();
  		sum += current;
  		min = Math.min(min, current);
  	}

  	int result = sum / NUMBER_OF_PLAYERS ;

  	if (sum % NUMBER_OF_PLAYERS != 0 || result == 0) {
  		output.println(-1);
  	} else {
  		output.println(result);
  	}
  }
}
