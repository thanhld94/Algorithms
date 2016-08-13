import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	Card[] cards = new Card[n];
  	for (int i = 0; i < n; i++) {
  		cards[i] = new Card(i + 1, input.nextInt());
  	}
  	Arrays.sort(cards);
  	for (int i = 0; i < n/2; i++) {
  		output.println(cards[i].idx + " " + cards[n - i - 1].idx);
  	}
  }

  private class Card implements Comparable<Card> {
  	int value;
  	int idx;

  	private Card(int idx, int value) {
  		this.value = value;
  		this.idx = idx;
  	}

  	@Override public int compareTo(Card other) {
  		return (value - other.value);
  	}
  }
}
