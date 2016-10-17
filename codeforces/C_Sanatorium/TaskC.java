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
    long[] meals = new long[3];
    long ndays = 0;
    for (int i = 0; i < 3; i++) {
      meals[i] = input.nextLong();
      ndays = Math.max(ndays, meals[i]);
    }

    if (ndays == 0) {
      output.println(0);
      return;
    }
    
    long result = Long.MAX_VALUE;
    for (int mask = 1; mask <= 7; mask++) {
      long missed = 0L;
      boolean bad = false;
      for (int i = 0; i < 3; i++) {
        if ((mask & (1 << i)) != 0) {
          missed += (ndays - meals[i]);
        } else {
          if (meals[i] > ndays - 1) {
            bad = true;
            break;
          }
          missed += (ndays - 1 - meals[i]);
        }
      }
      if (!bad) {
        result = Math.min(result, missed);
      }
    }
    output.println(result);
  }
}
