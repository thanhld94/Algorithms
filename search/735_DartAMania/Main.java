import java.io.*;
import java.util.*;

public class Main {
  
  Set <Integer> values = new HashSet<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    while (n > 0) {
      int count = getPerm(n);
      if (count > 0) {
        output.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", n, getCom(n));
        output.printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", n, count);
        output.printf("**********************************************************************\n");
      } else {
        output.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", n);
        output.printf("**********************************************************************\n");
      }
      st = new StringTokenizer(input.readLine());
      n = Integer.parseInt(st.nextToken());
    }
    output.println("END OF OUTPUT");
  }

  private int getPerm(int val) {
    int result = 0;
    for (int dart1 : values) {
      for (int dart2 : values) {
        int rem = val - dart1 - dart2;
        if (values.contains(rem)) {
          result++;
        }
      }
    }
    return result;
  }

  private int getCom(int val) {
    int result = 0;
    for (int dart1 : values) {
      for (int dart2 : values) {
        int rem = val - dart1 - dart2;
        if (dart1 <= dart2 && dart2 <= rem && values.contains(rem)) {
          result++;
        }
      }
    }
    return result;
  }

  private void init() {
    for (int i = 0; i <= 20; i++) {
      values.add(i);
      values.add(i * 2);
      values.add(i * 3);
    }
    values.add(50);
  }
}
