/*
ID: thanhld1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

public class combo {

  private int[] john;
  private int[] master;
  private int n;
  private int result;
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("combo.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
    combo sol = new combo();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(input.readLine());
    john = new int[3];
    for (int i = 0; i < 3; i++) {
      john[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(input.readLine());
    master = new int[3];
    for (int i = 0; i < 3; i++) {
      master[i] = Integer.parseInt(st.nextToken());
    }

    result = 0;
    int[] combination = new int[3];
    generate(combination, 0);
    output.println(result);
  }

  private void generate(int[] current, int idx) {
    if (idx == current.length) {
      if (validCombo(current)) {
        result++;
      }
      return;
    }

    for (int i = 1; i <= n; i++) {
      current[idx] = i;
      generate(current, idx + 1);
    }
  }
  
  private boolean validCombo(int[] seq) {
    int diffJohn = 0;
    int diffMaster = 0;
    for (int i = 0; i < seq.length; i++) {
      diffJohn = Math.max(diffJohn, Math.min(Math.abs(seq[i] - john[i]), n - Math.abs(seq[i] - john[i])));
      diffMaster = Math.max(diffMaster, Math.min(Math.abs(seq[i] - master[i]), n - Math.abs(seq[i] - master[i])));
    }
    return (diffJohn <= 2 || diffMaster <= 2);
  }
}
