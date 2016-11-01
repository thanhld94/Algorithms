import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	Map <Integer, Integer> apps = new HashMap <Integer, Integer>();
  	int max = -1;
  	for (int i = 0; i < n; i++) {
  		int a = input.nextInt();
  		max = Math.max(max, a);
  		if (apps.containsKey(a)) {
  			apps.put(a, apps.get(a) + 1);
  		} else {
  			apps.put(a, 1);
  		}
  	}

  	long[] f = new long[max + 1];
  	f[1] = (apps.containsKey(1)) ? (1L) * apps.get(1) : 0L;

  	for (int i = 2; i <= max; i++) {
  		if (apps.containsKey(i)) {
  			f[i] = Math.max(f[i - 1], f[i - 2] + (1L) * apps.get(i) * i);
  		} else {
  			f[i] = f[i - 1];
  		}
  	}
  	output.println(f[max]);
  }
}
