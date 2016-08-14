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
  	int idxMax = -1;
  	int idxMin = -1;
  	int maxVal = 0;
  	int minVal = Integer.MAX_VALUE;

  	for (int i = 0; i < n; i++) {
  		int a = input.nextInt();
  		if (a > maxVal) {
  			idxMax = i;
  			maxVal = a;
  		}
  		if (a <= minVal) {
  			idxMin = i;
  			minVal = a;
  		}
  	}
  	int result = idxMax + (n - idxMin - 1);
  	if (idxMax > idxMin) {
  		result--;
  	}
  	output.println(result);
  }
}
