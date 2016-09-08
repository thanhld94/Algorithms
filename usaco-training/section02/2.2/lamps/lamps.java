/*
ID: thanhld1
LANG: JAVA
TASK: lamps
*/

import java.util.*;
import java.io.*;

public class lamps {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("lamps.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
    lamps sol = new lamps();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(input.readLine());
    int c = Integer.parseInt(st.nextToken());
    
    boolean[] turnedOn = new boolean[n];
    boolean[] turnedOff = new boolean[n];
    st = new StringTokenizer(input.readLine());
    int temp = Integer.parseInt(st.nextToken());
    while (temp != -1) {
      turnedOn[temp - 1] = true;
      temp = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(input.readLine());
    temp = Integer.parseInt(st.nextToken());
    while (temp != -1) {
      turnedOff[temp - 1] = true;
      temp = Integer.parseInt(st.nextToken());
    }

    int[] status = new int[n];
    List<LampStatus> result = new ArrayList<LampStatus>();
    for (int button1 = 0; button1 <= 1; button1++) {
      for (int button2 = 0; button2 <= 1; button2++) {
        for (int button3 = 0; button3 <= 1; button3++) {
          for (int button4 = 0; button4 <= 1; button4++) {
            int total = button1 + button2 + button3 + button4;
            if (total <= c && total % 2 == c % 2) {
              if (check(button1, button2, button3, button4, n, turnedOn, turnedOff, status)) {
                result.add(new LampStatus(status));
              }
            }
          }
        }
      }
    }

    Collections.sort(result);
    if (result.size() == 0) {
      output.println("IMPOSSIBLE");
    } else {
      for (int i = 0; i < result.size(); i++) {
        if (i == 0 || result.get(i).compareTo(result.get(i - 1)) != 0) {
          for (int val : result.get(i).status) {
            output.print(val);
          }
          output.println();
        }
      }
    }
  } 

  private boolean check(int b1, int b2, int b3, int b4, int n, boolean[] turnedOn, boolean[] turnedOff, int[] status) {
    for (int i = 0; i < n; i++) {
      status[i] = 1;
    }

    if (b1 > 0) {
      for (int i = 0; i < n; i++) {
        status[i] ^= 1;
      }
    }

    if (b2 > 0) {
      for (int i = 0; i < n; i += 2) {
        status[i] ^= 1;
      }
    }

    if (b3 > 0) {
      for (int i = 1; i < n; i += 2) {
        status[i] ^= 1;
      }
    }

    if (b4 > 0) {
      for (int i = 0; i < n; i += 3) {
        status[i] ^= 1;
      }
    }

    for (int i = 0; i < n; i++) {
      if (status[i] == 1 && turnedOff[i]) {
        return false;
      }
      if (status[i] == 0 && turnedOn[i]) {
        return false;
      }
    }
    return true;
  }

  private class LampStatus implements Comparable<LampStatus> {
    private int[] status;

    private LampStatus(int[] arr) {
      status = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
        status[i] = arr[i];
      }
    }

    @Override public int compareTo(LampStatus other) {
      for (int i = 0; i < status.length; i++) {
        if (status[i] != other.status[i]) {
          return status[i] - other.status[i];
        }
      }
      return 0;
    }
  }
}
