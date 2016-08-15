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
  	int t = input.nextInt() - 1;
  	int[] portal = new int[n - 1];
  	boolean[] visited = new boolean[n];
  	for (int i = 0; i < n - 1; i++) {
  		portal[i] = input.nextInt();
  	}

  	int idx = 0; 
  	while (true) {
  		visited[idx] = true;
  		if (idx == t || idx == n - 1) {
  			break;
  		}
  		idx += portal[idx];
  	}
  	if (visited[t]) {
  		output.println("YES");
  	} else {
  		output.println("NO");
  	}
  }
}
