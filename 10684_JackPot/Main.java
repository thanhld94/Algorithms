import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PrintWriter output = new PrintWriter(System.out);
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }
  
  public void solve(Scanner input, PrintWriter output) {
    while (true) {
      int n = input.nextInt();
      if (n == 0) {
        return;
      }
      int[] bets = new int[n];
      for (int i = 0; i < n; i++) {
        bets[i] = input.nextInt();
      }
      process(bets, output);
    }
  }

  private void process(int[] bets, PrintWriter output) {
    int n = bets.length;
    int current = 0;
    int result = -1;
    for (int i = 0; i < n; i++) {
      current += bets[i];
      result = Math.max(result, current);
      if (current < 0) {
        current = 0;
      }
    }
    if (result > 0) {
      output.printf("The maximum winning streak is %d.\n",result);
    } else {
      output.println("Losing streak.");
    }
  }
}
