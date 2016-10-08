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
    char[] crock = input.next().toCharArray();
    
    int offblue = 0;
    int offred = 0;
    char flag = 'b';
    for (int i = 0; i < n; i++) {
      if (crock[i] != flag) {
        if (flag == 'b') {
          offred++;
        } else {
          offblue++;
        }
      }
      flag = (flag == 'b') ? 'r' : 'b';
    }
    int result = Math.max(offblue, offred);

    offblue = 0;
    offred = 0;
    flag = 'r';
    for (int i = 0; i < n; i++) {
      if (crock[i] != flag) {
        if (flag == 'b') {
          offred++;
        } else {
          offblue++;
        }
      }
      flag = (flag == 'b')? 'r' : 'b';
    }
    result = Math.min(result, Math.max(offred, offblue));
    output.println(result); 
  }
}
