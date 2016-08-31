import java.util.*;

public class ColorfulDecoration
{
	public int getMaximum(int[] xa, int[] ya, int[] xb, int[] yb)
	{
		int l = 0;
		int r = 1000000000;
		int result = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (check(xa, ya, xb, yb, mid)) {
				result = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return result;
	}
	
	private boolean check(int[] xa, int[] ya, int[] xb, int[] yb, int range) {
		int n = xa.length;
		boolean[][] connected = new boolean[n * 2][n * 2];
		for (int i = 0; i < n + n; i++) {
			for (int j = 0; j < n + n; j++) {
				if (i % n != j % n) {
					int xi = (i < n) ? xa[i] : xb[i - n];
					int yi = (i < n) ? ya[i] : yb[i - n];
					int xj = (j < n) ? xa[j] : xb[j - n];
					int yj = (j < n) ? ya[j] : yb[j - n];
					if (Math.abs(xi - xj) < range && Math.abs(yi - yj) < range) {
						int j_ = (j < n) ? j + n : j - n;
						connected[i][j_] = true;
					}
				}
			}
		}
			
		for (int k = 0; k < n + n; k++) {
			for (int i = 0; i < n + n; i++) {
				for (int j = 0; j < n + n; j++) {
						if (connected[i][k] && connected[k][j]) {
						connected[i][j] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (connected[i][i + n] && connected[i + n][i]) {
				return false;
			}
		}
		return true;
	}
	
	
}
