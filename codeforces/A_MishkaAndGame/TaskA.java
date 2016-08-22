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
  	int countA = 0;
  	int countB = 0;
  	for (int i = 0; i < n; i++) {
  		int valueA = input.nextInt();
  		int valueB = input.nextInt();
  		if (valueA < valueB) {
  			countB++;
  		}
  		if (valueB < valueA) {
  			countA++;
  		}
  	}
  	if (countA > countB) {
  		output.println("Mishka");
  	} else if (countB > countA) {
  		output.println("Chris");
  	} else {
  		output.println("Friendship is magic!^^");
  	}
  }
}
