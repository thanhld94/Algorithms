import java.io.PrintWriter;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    String text = input.next();
    Set <Character> pokes = new HashSet <Character>();
    
    for (int i = 0; i < n; i++) {
      char type = text.charAt(i);
      pokes.add(type);
    }

    Map <Character, Integer> last = new HashMap <Character, Integer>();
    for (char poke : pokes) {
      last.put(poke, -1);
    }

    int result = n;
    for (int i = 0; i < n; i++) {
      char type = text.charAt(i);
      last.put(type, i);

      boolean valid = true;
      for (char poke : pokes) {
        if (last.get(poke) == -1) {
          valid = false;
          break;
        }
      }

      if (valid) {
        int first = Integer.MAX_VALUE;
        //output.println("i = " + i);
        for (char poke : pokes) {
          first = Math.min(first, last.get(poke));
          //output.println(" last " + poke + " at " + last.get(poke));
        }
        //output.println(" -> len = " + (i - first + 1));
        result = Math.min(result, i - first + 1);
      }
    }
    output.println(result);
  }
}
