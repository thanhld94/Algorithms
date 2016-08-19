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
  	int d = input.nextInt();
  	int time = 0;
  	int jokes = 0;
  	for (int i = 0; i < n; i++) {
  		time += input.nextInt();
  		if (i < n - 1) {
  			time += 10;
  			jokes += 2;
  		}
  	}
  	if (time > d) {
  		output.println(-1);
  	} else {
  		jokes += (d - time) / 5;
  		output.println(jokes);
  	}
  }
}
