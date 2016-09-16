import java.io.*;
import java.util.*;

public class Main {
  
  int nfront;
  int nrear;
  int[] front = new int[111];
  int[] rear = new int[111];
  List <Double> values;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    nfront = Integer.parseInt(st.nextToken());
    while (nfront != 0) {
      nrear = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(input.readLine());
      for (int i = 0; i < nfront; i++) {
        front[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(input.readLine());
      for (int i = 0; i < nrear; i++) {
        rear[i] = Integer.parseInt(st.nextToken());
      }

      output.printf("%.2f\n", getResult());
      
      st = new StringTokenizer(input.readLine());
      nfront = Integer.parseInt(st.nextToken());
    }
  }

  private double getResult() {
    values = new ArrayList <Double>();
    for (int i = 0; i < nrear; i++) {
      for (int j = 0; j < nfront; j++) {
        //System.out.println("rear = " + rear[i] + " front = " + front[j]);
        values.add((1.0) * rear[i] / front[j]);
      }
    }
    Collections.sort(values);
    
    double result = Double.MIN_VALUE;
    for (int i = 1; i < values.size(); i++) {
      result = Math.max(result, 1.0 * values.get(i) / values.get(i - 1));
    }
    return result;
  }
}
