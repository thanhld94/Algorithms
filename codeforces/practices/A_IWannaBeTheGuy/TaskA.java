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
  	boolean[] levels = new boolean[n];
  	
  	int np = input.nextInt();
  	for (int i = 0; i < np; i++) {
  		int level = input.nextInt();
  		levels[level - 1] = true;
  	}

  	int nq = input.nextInt();
  	for (int i = 0; i < nq; i++) {
  		int level = input.nextInt();
  		levels[level - 1] = true;
  	}

  	for (boolean level : levels) {
  		if (!level) {
  			output.println("Oh, my keyboard!");
  			return;
  		}
  	}
  	output.println("I become the guy.");
  }
}
