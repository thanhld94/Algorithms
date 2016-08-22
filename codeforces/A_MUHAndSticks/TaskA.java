import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskA{
  public static final int MID = 3;
  
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int[] len = new int[6];
    for (int i = 0; i < 6; i++) {
      len[i] = input.nextInt();
    }
    Arrays.sort(len);
    boolean[] legs = new boolean[6];
    int count = 0;
    for (int i = 0; i < 6; i++) {
      if (len[i] == len[MID]) {
        count++;
        legs[i] = true;
        if (count == 4) {
          break;
        }
      }
    }
    
    if (count < 4) {
      output.println("Alien");
      return;
    }
    
    int head = -1;
    int body = -1;
    for (int i = 0; i < 6; i++) {
      if (!legs[i]) {
        if (head == -1) {
          head = len[i];
        } else {
          body = len[i];
        }
      }
    }

    if (head < body) {
      output.println("Bear");
    } else {
      output.println("Elephant");
    }
  }
}
