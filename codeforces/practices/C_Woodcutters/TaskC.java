import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int[] x = new int[n];
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = input.nextInt();
      h[i] = input.nextInt();
    }

    int count = 1;
    int last = x[0];
    for (int i = 1; i < n; i++) {
      if (x[i] - h[i] > last) { //can fall to the left
        count++;
        last = x[i];
      } else {
        if (i + 1 >= n || x[i] + h[i] < x[i + 1]) { // can fall to the right
          count++;
          last = x[i] + h[i];
        } else { // fall the the right 
          last = x[i];
        }
      }
    }
    output.println(count);
  }
}
