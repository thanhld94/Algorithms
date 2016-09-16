import java.util.*;
import java.io.*;

public class Main {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int test = 0;
    while (input.hasNextInt()) {
      int c = input.nextInt();
      int s = input.nextInt();
      int[] weights = new int[s];
      double avg = 0.0;
      for (int i = 0; i < s; i++) {
        weights[i] = input.nextInt();
        avg += weights[i];
      }
      avg /= c;

      Arrays.sort(weights);
      List<List<Integer> > chambers = new ArrayList<List<Integer> >();
      for (int i = 0; i < c; i++) {
        chambers.add(new ArrayList<Integer>());
      }
      
      double imbalance = 0;
      int current = 0;

      int numSingles = 2 * c - s;
      int last = s - 1;
      for (int i = 0; i < numSingles; i++) {
        imbalance += Math.abs(avg - weights[last]);
        chambers.get(i).add(weights[last--]);
      }

      int first = 0;
      for (int i = numSingles; i < c; i++) {
        imbalance += Math.abs(avg - weights[last] - weights[first]);
        chambers.get(i).add(weights[last--]);
        chambers.get(i).add(weights[first++]);
      }

      output.printf("Set #%d\n", ++test);
      for (int i = 0; i < c; i++) {
        output.printf("%d: ", (i + 1));
        for (int weight : chambers.get(i)) {
          output.print(weight + " ");
        }
        output.println();
      }
      output.printf("IMBALANCE = %.5f\n\n", imbalance);
    }
  }
}
