import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int na = input.nextInt();
    Queue <Integer> aCards = new LinkedList <Integer>();
    for (int i = 0; i < na; i++) {
      int a = input.nextInt();
      aCards.add(a);
    }
    int nb = input.nextInt();
    Queue <Integer> bCards = new LinkedList <Integer>();
    for (int i = 0; i < nb; i++) {
      int b = input.nextInt();
      bCards.add(b);
    }

    int count = 0;
    while (aCards.size() > 0 && bCards.size() > 0) {
      int topA = aCards.poll();
      int topB = bCards.poll();
      if (count > (1 << 20)) {
        output.println(-1);
        return;
      }
      count++;
      if (topA > topB) {
        aCards.add(topB);
        aCards.add(topA);
      } else {
        bCards.add(topA);
        bCards.add(topB);
      }
    }
    output.print(count + " ");
    if (aCards.size() == 0) {
      output.println(2);
    } else {
      output.println(1);
    }
  }
}
