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
  	int count = 0;
  	int npolice = 0;
  	for (int i = 0; i < n; i++) {
  		int event = input.nextInt();
  		if (event > 0) npolice += event;
  		else {
  			if (npolice == 0) count++;
  			else {
  				npolice--;
  			}
  		}
  	}
  	output.println(count);
  }
}
