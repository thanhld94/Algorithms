import java.io.PrintWriter;
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	String direction = input.next();
  	String text = input.next();
		Map <Character, Character> map = init(direction);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i))) {
				sb.append(map.get(text.charAt(i)));
			} else {
				sb.append(text.charAt(i));
			}
		}
		output.println(sb.toString());
  }

  private Map <Character, Character> init(String dir) {
  	Map <Character, Character> result = new HashMap <Character, Character>();
		String[] rows = {"qwertyuiop", "asdfghjkl;", "zxcvbnm,./"};
		for (String row : rows) {
			if (dir.equals("L")) {
				for (int i = 0; i < row.length() - 1; i++) {
					result.put(row.charAt(i), row.charAt(i + 1));
				}
			} else {
				for (int i = row.length() - 1; i > 0; i--) {
					result.put(row.charAt(i), row.charAt(i - 1));
				}
			}
		}
		return result;
  }
}
