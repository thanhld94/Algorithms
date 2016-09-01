import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class StringPermutation {


	public List<Character[]> permutations(char[] s) {
		List<Character[]> result = new ArrayList<Character[]>();
		Character[] perm = new Character[s.length];
		boolean[] used = new boolean[s.length];
		Arrays.sort(s);
		generate(s,0,perm,used, result);
		return result;
	}

	private void generate(char[] s, int idx, Character[] perm, boolean[] used, List<Character[]> result) {
		if (idx >= s.length) {
			result.add(perm.clone());
			return;
		}
		for (int i = 0; i < s.length; i++) {
			if (!used[i]) {
				used[i] = true;
				perm[idx] = s[i];
				generate(s, idx + 1, perm, used, result);
				used[i] = false;
				while (i+1 < s.length && s[i] == s[i+1])
					i++;
			}
		}
	}

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		char[] s = {'a','b','b','c'};
		List<Character[]> result = sp.permutations(s);
		for (int i = 0; i < result.size(); i++) {
		 	Character[] res = result.get(i);
		 	for(int j = 0; j < res.length; j++) 
		 		System.out.print(res[j] + " ");
		 	System.out.println();
		}
	}
}
