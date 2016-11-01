import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TaskC{
  private static final int MAX = 1000000000;
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int m = input.nextInt();
    Map <Integer, Boolean> collected = new HashMap <Integer, Boolean>();
    for (int i = 0; i < n; i++) {
      int idx = input.nextInt();
      collected.put(idx, true);
    }

    int count = 0;
    List <Integer> toys = new ArrayList<Integer>();
    for (int i = 1; i < MAX; i++) {
      if (m < i) {
        break;
      }
      if (!collected.containsKey(i)) {
        count++;
        toys.add(i);
        m -= i;
      }
    }

    output.println(count);
    for (Integer toy : toys) {
      output.print(toy + " ");
    }
    output.println();
  }
}
