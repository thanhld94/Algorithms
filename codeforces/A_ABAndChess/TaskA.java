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
  	String[] rows = new String[8];
  	for (int i = 0; i < 8; i++) {
  		rows[i] = input.next();
  	}

  	int[] score = new int[2];

  	for (String row : rows) {
  		for (int i = 0; i < 8; i++) {
  			if ('A' <= row.charAt(i) && row.charAt(i) <= 'Z') { //White
  				score[0] += getScore(row.charAt(i));
  			} else if ('a' <= row.charAt(i) && row.charAt(i) <= 'z') { //Black
  				score[1] += getScore(row.charAt(i));
  			}
  		}
  	}
  	if (score[0] == score[1]) {
  		output.println("Draw");
  	} else if (score[0] > score[1]) {
  		output.println("White");
  	} else {
  		output.println("Black");
  	}
  }

  private int getScore(char c) {
  	if (c == 'q' || c == 'Q') return 9;
  	if (c == 'r' || c == 'R') return 5;
  	if (c == 'b' || c == 'B') return 3;
  	if (c == 'n' || c == 'N') return 3;
  	if (c == 'p' || c == 'P') return 1;
  	return 0;
  }
}
