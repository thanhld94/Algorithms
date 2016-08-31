import java.util.*;

public class WeirdTimes
{
	int n;
	int[] minutes;
	long[][] f;
	int k;

	private long count(int idx, int current) {
		if (f[idx][current] != -1) {
			return f[idx][current];
		}
		if (idx == n) {
			f[idx][current] = 0;
			return 0;
		}
		int next = current;
		if (idx + 1 < n && minutes[idx] >= minutes[idx + 1]) {
			next++;
		}
		int result = 0;
		for (int i = next; i < 24; i++) {
			result += count(idx + 1, i);
		}
		f[idx][current] = result;
		return result;
	}

	public int[] hourValues(int[] minuteValues, int K)
	{
		n = minuteValues.length;
		minutes = minuteValues;
		k = K;
		f = new long[n + 1][25];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= 24; j++) {
				f[i][j] = -1L;
			}
		}
		
		for (int i = 0; i < 24; i++) {
			f[n - 1][i] = 1L;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 24; j++) {
				count(i,j);
			}
		}
		
		int[] notFound = {-1};
		int[] result = new int[n];
		int current = 0;
		for (int i = 0; i < n; i++) {
			if (i > 0 && minuteValues[i] <= minuteValues[i - 1]) {
				current++;
			}
			while (current < 24 && k > f[i][current]) {
				k -= f[i][current];
				current++;
			}
			if (current >= 24) {
				return notFound;		
			}
			result[i] = current;
		}
		return result;
	}
	
	
}
