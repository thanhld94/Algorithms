/*
ID: thanhld1
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class holstein {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("holstein.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
    holstein sol = new holstein();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int v = Integer.parseInt(st.nextToken());
    int[] required = new int[v];

    st = new StringTokenizer(input.readLine());
    for (int i = 0; i < v; i++) {
      required[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(input.readLine());
    int g = Integer.parseInt(st.nextToken());
    int[][] type = new int[g][v];
    for (int i = 0; i < g; i++) {
      st = new StringTokenizer(input.readLine());
      for (int j = 0; j < v; j++) {
        type[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] chosen = new int[g];
    int[] result = new int[g];
    for (int i = 0; i < g; i++) {
      result[i] = 1;
    }
    generate(chosen, 0, type, required, result);
    
    int count = 0;
    for (int val : result) {
      count = (val == 1) ? count + 1 : count;
    }
    output.print(count);
    for (int i = 0; i < g; i++) {
      if (result[i] == 1) {
        output.print(" " + (i + 1));
      }
    }
    output.println();
  }

  private void generate(int[] chosen, int idx, int[][] types, int[] required, int[] result) {
    if (idx == chosen.length) {
      int cnt = 0;
      int[] total = new int[required.length];
      for (int type = 0; type < types.length; type++) {
        if (chosen[type] == 1) {
          cnt++;
          for (int vitamin = 0; vitamin < required.length; vitamin++) {
            total[vitamin] += types[type][vitamin];
          }
        }
      }

      int currentResult = 0;
      for (int val : result) {
        currentResult = (val == 1) ? currentResult + 1 : currentResult;
      }

      if (cnt < currentResult) {
        boolean check = true;
        for (int vitamin = 0; vitamin < required.length; vitamin++) {
          if (total[vitamin] < required[vitamin]) {
            check = false;
            break;
          }
        }
        if (check) {
          for (int type = 0; type < types.length; type++) {
            result[type] = chosen[type];
          }
        }
      }
      return;
    }

    chosen[idx] = 1;
    generate(chosen, idx + 1, types, required, result);
    chosen[idx] = 0;
    generate(chosen, idx + 1, types, required, result);
  }
}
