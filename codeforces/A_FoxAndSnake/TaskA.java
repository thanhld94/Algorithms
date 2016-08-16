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
  	int m = input.nextInt();
  	int flag = 1;
  	for (int i = 0; i < n; i++) {
  		for (int j =  0; j < m; j++) {
  			output.print('#');
  		}
  		output.println();
  		i++;
  		if (i < n) {
  			for (int j = 0; j < m; j++) {
  				if (j == flag * (m - 1)) {
  					output.print('#');
  				} else {
  					output.print('.');
  				}
  			}
  			output.println();
  			flag ^= 1;
  		}
  	}
  }
}
