/*
ID: thanhld1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

public class friday {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("friday.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    StringTokenizer st = new StringTokenizer(input.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[] days = new int[7];
    int current13 = 0; // first 13 is Sunday
    days[current13]++;
    // 0 1 0 0 0 0 0
    for (int i = 0; i < n; i++) {
      int year = 1900 + i;
      for (int month = 1; month <= 12; month++) {
        int next13 = (current13 + getDaysInMonth(month, year)) % 7;
        days[next13]++;
        current13 = next13;
      }
    }
    days[current13]--;
    output.print(days[0]);
    for (int i = 1; i < 7; i++) {
      output.print(" " + days[i]);
    }
    output.println();
    output.close();
  }

  private static int getDaysInMonth(int month, int year) {
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    if (month != 2) {
      return 31;
    }
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
      return 29;
    }
    return 28;
  }
}
