import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int m = input.nextInt();
  	int[] a = new int[n];
  	int[] b = new int[m];
  	int high = Integer.MIN_VALUE;
  	int low = Integer.MAX_VALUE;
  	for (int i = 0; i < n; i++) {
  		a[i] = input.nextInt();
  		high = Math.max(high, a[i]);
  		low = Math.min(low, a[i]);
  	}
  	for (int i = 0; i < m; i++) {
  		b[i] = input.nextInt();
  		high = Math.max(high, b[i]);
  		low = Math.min(low, b[i]);
  	}
  	Arrays.sort(a);
  	Arrays.sort(b);

  	int l = 0;
  	int r = high - low;
  	// System.out.println("high = " + high + " low = " + low);
  	int result = -1;
  	while (l <= r) {
  		int mid = l/2 + r/2;
  		if (l % 2 == 1 && r % 2 == 1) mid++;
  		// output.println(l + " " + mid + " " + r);
  		if (canCover(a, b, mid)) {
  			result = mid;
  			r = mid - 1;
  			// output.println(result);
  		} else {
  			l = mid + 1;
  		}
  	}
  	output.println(result);
  }

  private boolean canCover(int[] a, int[] b, int range) {
  	for (int i = 0; i < a.length; i++) {
  		int l = 0;
  		int r = b.length - 1;
  		int result = -1;
  		while (l <= r) {
  			int mid = (l + r) / 2;
  			if (b[mid] <= a[i]) {
  				result = mid;
  				l = mid + 1;
  			} else {
  				r = mid - 1;
  			}
  		}
  		int closest = Integer.MAX_VALUE;
  		if (result == -1) closest = b[0] - a[i];
  		else {
  			closest = a[i] - b[result];
  			if (result < b.length - 1) 
  				closest = Math.min(closest, b[result + 1] - a[i]);
  			// System.out.println("    closest = " + closest);
  		}
  		// System.out.println("  i = " + i + " closest = " + closest + " range = " + range);
  		if (closest > range) return false;
  	}
  	return true;
  }
}