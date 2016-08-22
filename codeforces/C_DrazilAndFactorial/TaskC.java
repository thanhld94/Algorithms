import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TaskC{
  
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    List<List<Integer>> factors = initFactorList();
    int n = input.nextInt();
    String s = input.next();
    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < s.length(); i++) {
      int digit = s.charAt(i) - '0';
      for (Integer x : factors.get(digit)) {
        result.add(-1 * x);
      }
    }
    Collections.sort(result);
    for (Integer digit : result) {
      output.print(-1 * digit);
    }
    output.println();
  }
    
  private List<List<Integer>> initFactorList() {
    List<List<Integer>> factors = new ArrayList<List<Integer>>();
    for (int i = 0; i < 10; i++) {
      List<Integer> list = new ArrayList<Integer>();
      if (i >= 2) {
        if (i == 2 || i == 3 || i == 5 || i == 7) {
          list.add(i);
        } else {
          if (i == 4) {
            list.add(2);
            list.add(2);
            list.add(3);
          } else if (i == 6) {
            list.add(5);
            list.add(3);
          } else if (i == 8) {
            list.add(2);
            list.add(2);
            list.add(2);
            list.add(7);
          } else if (i == 9) {
            list.add(7);
            list.add(3);
            list.add(3);
            list.add(2);
          }
        }
      }
      factors.add(list);
    }
    return factors;
  }
}
