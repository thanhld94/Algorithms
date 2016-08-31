import java.util.*;

public class ColorfulStrings
{
	private int[] digits;
	private int n;
	private int k;
	private int count;
	private int[] prods;
	private boolean[] used;

	public String getKth(int n, int k)
	{
		this.n = n;
		this.k = k;
		if (n == 1) {
			if (k <= 10) {
				return "" + (k - 1);
			} 
			return "";
		}
		if (n > 8) {
			return "";
		}
		
		digits = new int[n];
		prods = new int[n];
		used = new boolean[10];
		count = 0;
		gen(0);
		String result = "";
		if (count == k) {
			for (int digit : digits) {
				result += digit;
			}
		}
		return result;
	}
	
	private void gen(int idx) {
		if (count == k) {
			return;
		}
		
		if (idx == n) {
			if (check()) {
				count++;
			}
			return;
		}
		
		for (int i = 2; i < 10; i++) {
			if (count >= k) {
				return;
			}
			if (!used[i]) {
				used[i] = true;
				digits[idx] = i;
				gen(idx + 1);
				used[i] = false;
			}
		}
	}
	
	private boolean check() {
		Map <Integer, Boolean> map = new HashMap <Integer, Boolean>();
		prods[0] = digits[0];
		for (int i = 1; i < n; i++) {
			prods[i] = prods[i - 1] * digits[i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int p = prods[j];
				if (i > 0) {
					p /= prods[i - 1];
				}
				if (map.containsKey(p)) {
					return false;
				} else {
					map.put(p, true);
				}
			}
		}
		return true;
	}
}
