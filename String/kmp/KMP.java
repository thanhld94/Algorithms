public class KMP {
    private String text;
    private String pattern;

    public static void main(String[] args) {
        String text = "There is something with something, where something is something else. Someone is bringing something, he sees some thing";
        System.out.println("Text = " + text);
        KMP kmp = new KMP(text, args[0]);
        int first = kmp.firstMatch();
        System.out.println("First match start at: " + first);
        if (first > -1) {
            int start = first - 10;
            if (start < 0) 
                start = 0;
            int finish = first + args[0].length();
            if (finish + 10 < text.length())
                finish += 10;
            System.out.println(text.substring(start, finish));
        }
    }

    public KMP(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }
    
    private int[] getFailureFunction() {
        int[] f = new int[pattern.length() + 1];
        f[0] = 0;
        f[1] = 0;
        for (int i = 2; i <= pattern.length(); i++) {
            int j = f[i-1];
            while (true) {
                if (pattern.charAt(j) == pattern.charAt(i-1)) {
                    f[i] = j + 1;
                    break;
                }
                if (j == 0) {
                    f[i] = 0;
                    break;
                }
                j = f[j];
            }
        }
        return f;
    }

    public int firstMatch() {
        int[] failureFunction = getFailureFunction();
        int i = 0;
        int j = 0;
        while (true) {
            if (j == text.length()) // End of text, no match 
                return -1;
            if (text.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
                if (i == pattern.length()) { // found match in text
                    return j - pattern.length();
                }
            } else {
                if (i > 0) { // There might be a shorter prefix that we can try
                    i = failureFunction[i];
                } else { // There is no match, move on to the next char
                    j++;
                }
            }
        }
    }
}
