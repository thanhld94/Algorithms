import java.io.PrintWriter;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    List<Integer> unique = getUnique(a);
    if (unique.size() < 3 || (unique.size() == 3 && unique.get(2) - unique.get(1) == unique.get(1) - unique.get(0))) {
      output.println("YES");
    } else {
      output.println("NO");
    }
  }

  private List<Integer> getUnique(int[] a) {
    Arrays.sort(a);
    List<Integer> result = new ArrayList<Integer>();
    result.add(a[0]);
    for (int val : a) {
      if (val != result.get(result.size() - 1)) {
        result.add(val);
      }
    }
    return result;
  }
}
