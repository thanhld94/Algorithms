import java.io.PrintWriter;
import java.util.*;

public class TaskA {
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    String[] days = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
    Map<String, Integer> map = new HashMap<String, Integer>();
    int[] nd = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    for (int i = 0; i < days.length; i++) {
      map.put(days[i], i);
    }

    int first = map.get(input.next());
    int second = map.get(input.next());
    for (int i = 0; i < days.length; i++) {
      int current = i;
      for (int j = 0; j < nd.length - 1; j++) {
        current = (current + nd[j]) % 7;
        int next = (current + nd[j + 1]) % 7;
        if (current == first && next == second) {
          output.println("YES");
          return;
        }
      }
    }
    output.println("NO");
  }
}
