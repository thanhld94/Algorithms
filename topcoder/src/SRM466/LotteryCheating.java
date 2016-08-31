import java.util.*;

public class LotteryCheating
{
	public int minimalChange(String ID)
	{
		List<Long> squares = new ArrayList<Long>();
		long MAX = 0;
		for (int i = 0; i < ID.length(); i++) {
			MAX = MAX * 10 + 9;
		}
		
		for (long i = 0; i * i <= MAX; i++) {
			squares.add(i * i);
		}
		
		int min = ID.length();
		for (Long num : squares) {
			min = Math.min(min, compare(num, ID));
		}
		return min;
	}
	
	private int compare(long num, String id) {
		long[] digits = new long[id.length()];
		int idx = digits.length - 1;
		while (num > 0) {
			digits[idx] = num % 10;
			num /= 10;
			idx--;
		}
		int count = 0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != (id.charAt(i) - '0')) {
				count++;
			}
		}
		return count;
	}
	
	
}
