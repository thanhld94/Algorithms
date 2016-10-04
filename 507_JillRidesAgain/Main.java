import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Main mn = new Main();
    Scanner input = new Scanner(System.in);
    PrintWriter output = new PrintWriter(System.out);
    mn.solve(input, output);
    output.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int test = input.nextInt();
    for (int t = 0; t < test; t++) {
      int n = input.nextInt();
      int[] nice = new int[n - 1];
      for (int i = 0; i < n - 1; i++) {
        nice[i] = input.nextInt();
      }
      process(t + 1, nice, output);
    }
  }
  
  private void process(int test, int[] nice, PrintWriter output) {
    int first = 0;
    int last = 0;
    int result = -1;
    int current = 0;
    int currentFirst = 0;
    int currentLast = 0;
    for (int i = 0; i < nice.length; i++) {
      current += nice[i];
      if (current >= result) {
        if (result < current || (current == result && last - first < currentLast - currentFirst)) {
          result = current;
          first = currentFirst;
          last = currentLast;
        }
      }
      //System.out.println("t = " + test + " i = " + i + " first = " + first + " last = " + last);
      currentLast++;
      if (current < 0) {
        currentFirst = currentLast = i + 1;
        current = 0;
      }
    }
    if (result > 0) {
      output.printf("The nicest part of route %d is between stops %d and %d\n", test, first + 1, last + 2);
      //output.println((first + 1) + " " + (last + 2));
    } else {
      output.printf("Route %d has no nice parts\n", test); 
    }
  }
}
