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
  	int[] awayCount = new int[101];
  	int[] homeColor = new int[n];
  	
  	for (int i = 0; i < n; i++) {
  		homeColor[i] = input.nextInt();
  		int awayColor = input.nextInt();
  		awayCount[awayColor]++;
  	}

  	int result = 0;
  	for (int i = 0; i < n; i++) {
  		result += awayCount[homeColor[i]];
  	}
  	output.println(result);
  }
}
