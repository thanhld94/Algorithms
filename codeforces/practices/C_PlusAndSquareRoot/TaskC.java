import java.io.PrintWriter;
import java.util.*;
import java.math.BigInteger;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    BigInteger current = new BigInteger("2");
    for (int k = 2; k <= n + 1; k++) {
      BigInteger k_ = new BigInteger("" + k);
      BigInteger k_1 = new BigInteger("" + (k - 1));
                            
      BigInteger j = k_.multiply(k_1);
      BigInteger res = j.multiply(j).subtract(current).divide(k_1);
      output.println(res.toString());
      current = j;
    }
  }
}
