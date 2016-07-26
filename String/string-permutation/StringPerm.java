import java.util.Arrays;
import java.util.ArrayList;

public class StringPerm {
    private char[] chars;

    public static void main(String[] args) {
        StringPerm sp = new StringPerm(args[0]);
        ArrayList<String> perms = sp.getPermutation();
        for (int i = 0; i < perms.size(); i++) {
            System.out.println("perm " + i + ": " + perms.get(i));
        }
    }

    public StringPerm(String s) {
        chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            chars[i] = s.charAt(i);
        Arrays.sort(chars);
    }

    public ArrayList<String> getPermutation() {
        ArrayList<String> result = new ArrayList<String>();
        char[] perm = new char[chars.length];
        boolean[] used = new boolean[chars.length];
        findPerm(chars, used, perm, result, 0);
        return result;
    }

    private void findPerm(char[] chars, boolean[] used, char[] perm, ArrayList<String> result, int idx) {
        if (idx >= chars.length) {
            result.add(new String(perm));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                perm[idx] = chars[i];
                used[i] = true;
                findPerm(chars, used, perm, result, idx+1);
                used[i] = false;
                while (i+1 < chars.length && chars[i] == chars[i+1]) { // skipping same character
                    i++;
                }
            }
        }
    }
}
