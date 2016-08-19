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
  	int height = input.nextInt();
  	int width = n;
  	for (int i = 0; i < n; i++) {
  		int h = input.nextInt();
  		if (h > height) width++;
  	}
  	output.println(width);
  }
}
