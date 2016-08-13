import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	List<List<Integer>> app = new ArrayList<List<Integer>>();
  	for (int i = 0; i < 52; i++) {
  		app.add(new ArrayList<Integer>());
  	}

  	String flat = input.next();
  	for (int i = 0; i < n; i++) {
  		int hash = hashcode(flat.charAt(i));
  		app.get(hash).add(i);
  	}

  	int l = 1;
  	int r = n;
  	int result = 1;
  	while (l <= r) {
  		int mid = (l + r) / 2;
  		if (cancover(flat, mid, app)) {
  			result = mid;
  			r = mid - 1;
  		} else {
  			l = mid + 1;
  		}
  	}
  	output.println(result);
  }

  private boolean cancover(String flat, int range, List<List<Integer>> appearance) {
  	for (int i = 0; i <= flat.length() - range; i++) {
  		boolean found = true;
	  	for (int j = 0; j < 52; j++) {
	  		if (appearance.get(j).size() > 0) {
	  			int l = 0;
	  			int r = appearance.get(j).size() - 1;
	  			int res = 0;
	  			while (l <= r) {
	  				int mid = (l + r) / 2;
	  				if (appearance.get(j).get(mid) >= i) {
	  					res = mid;
	  					r = mid - 1;
	  				} else {
	  					l = mid + 1;
	  				}
	  			}

	  			if (i > appearance.get(j).get(res) || appearance.get(j).get(res) > i + range - 1) {
	  				found = false;
	  				break;
	  			}
	  		}
  		}
  		if (found) {
  			return true;
  		}
  	}
  	return false;
  }

  private int hashcode(char c) {
  	if ('a' <= c && c <= 'z') {
  		return c - 'a';
  	} else {
  		return 26 + c - 'A';
  	}
  }
}
