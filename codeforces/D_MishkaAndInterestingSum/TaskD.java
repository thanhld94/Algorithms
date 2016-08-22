import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class TaskD{
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	Map <Integer, Integer> map = new HashMap <Integer, Integer>();
  	int[] xors = new int[n];

  	for (int i = 0; i < n; i++) {
  		int num = input.nextInt();
  		if (map.containsKey(num)) {
  			map.put(num, map.get(num) + 1);
  		} else {
  			map.put(num, 1);
  		}
  		xors[i] = (i > 0) ? xors[i - 1] : 0;
  		if (map.get(num) > 1) {
  			xors[i] ^= num;
  		}
  		output.println(i + " -> " + xors[i]);
  	}

  	int q = input.nextInt();
  	for (int i = 0; i < q; i++) {
  		int l = input.nextInt() - 1;
  		int r = input.nextInt() - 1;
  		int result = (l > 0) ? xors[r] ^ xors[l - 1] : xors[r];
  		output.println(result);
  	}
  }
}
