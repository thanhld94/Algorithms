import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	char[] s = input.next().toCharArray();
  	for (int i = 0; i <= s.length-3; i++) {
  		if (s[i] == 'W' && s[i + 1] == 'U' && s[i + 2] == 'B') {
  			s[i] = s[i + 1] = s[i + 2] = ' ';
  		}
  	}

  	StringBuilder sb = new StringBuilder();
  	int idx = 0;
  	while (idx < s.length && s[idx] == ' ') idx++;
  	while (idx < s.length) {
  		while (idx < s.length && s[idx] != ' ') {
  			sb.append(s[idx++]);
  		}
  		while (idx < s.length && s[idx] == ' ') {
  			idx++;
  		}
  		if (idx < s.length) {
  			sb.append(' ');
  		}
  	}
  	output.println(sb.toString());
  }
}
