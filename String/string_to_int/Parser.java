import java.util.ArrayList;
import java.util.Hashtable;

public class Parser {
    String[] basicWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", 
        "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    int[] basicNumber = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90};

    String[] bigBaseMark = {"hundred", "thousand", "million", "billion"};
    int[] bigNumberBase = {100, 1000, 1000000, 1000000000};
    private Hashtable<String,Integer> mapWord;
    private Hashtable<String,Integer> mapBase;
    
    public static void main(String[] args) {
        //System.out.println((int) 'a' + " " + (int)'Z');
        String s = "One billion SeveN hundred and Thirty two million three hundred and sixty eight thousand eight hundred and twenty six";
        System.out.println("s = " + s);
        System.out.println(parseStringToWord(s));
        Parser mParser = new Parser();
        System.out.println(mParser.getEnglishNumber(s));
    }

    public Parser() {
        instantiateMapping();
    }

    public int getEnglishNumber(String s) {
        int result = 0;
        int base = 1;
        int num = 0;
        ArrayList<String> words = parseStringToWord(s);
        for (int i = 0; i < words.size(); i++) {
            //System.out.print("original: " + words.get(i) + " ");
            if (mapWord.get(words.get(i)) != null) {
                num += mapWord.get(words.get(i));
            } else if (mapBase.get(words.get(i)) != null) {
                base = mapBase.get(words.get(i));
                num *= base;
                if (base > 100) {
                    result += num;
                    base = 1;
                    num = 0;
                }
            }
        }
        return result + num;
    }

    private void instantiateMapping() {
        mapWord = new Hashtable<String,Integer>();
        mapBase = new Hashtable<String,Integer>();
        for (int i = 0; i < basicWord.length; i++) 
            mapWord.put(basicWord[i], basicNumber[i]);
        for (int i = 0; i < bigBaseMark.length; i++)
            mapBase.put(bigBaseMark[i], bigNumberBase[i]);

    }

    private static ArrayList<String> parseStringToWord(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++) { 
            if (s.charAt(i) > 'z' || s.charAt(i) < 'A') {
                //System.out.println("spec char: " + s.charAt(i) + " " + (int)s.charAt(i));
                String res = sb.toString();
                if (res.length() > 0) {
                    result.add(res.toLowerCase());
                    sb = new StringBuilder();
                }
            } else if ('A' <= s.charAt(i) && s.charAt(i) <= 'z') {
                //System.out.println(s.charAt(i) + " " + i);
                sb.append(s.charAt(i));
            }
        }
        String last = sb.toString();
        if (last.length() > 0) result.add(last);
        return result;
    }
}
