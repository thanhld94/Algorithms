import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class TaskB{
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      int num = input.nextInt();
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    long result = 0;

    for (Entry<Integer, Integer> e : map.entrySet()) {
      int num = e.getKey();
      int count1 = e.getValue();
      for (int pow = 1; pow < 32; pow++) {
        int rem = (1 << pow) - num;
        if (rem == num) {
          //output.println("num = " + num + " appeared = " + count1);
          result += ((1L)*count1 * (count1 - 1));
        } else {
          if (map.containsKey(rem)) {
            int count2 = map.get(rem);
            //output.println("num = " + num + " appeard = " + count2 + " num2  = " + rem + " appeared = " + count2);
            result += ((1L) * count1 * count2);
          }
        }
      }
      //output.println(" ==> result = " + result);
    }
    output.println(result / 2);
  }
}
