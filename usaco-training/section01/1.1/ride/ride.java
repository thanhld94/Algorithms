/*
ID: thanhld1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new FileReader("ride.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

    StringTokenizer st = new StringTokenizer(bf.readLine());
    String cometName = st.nextToken();
    st = new StringTokenizer(bf.readLine());
    String groupName = st.nextToken();

    int cometVal = 1;
    for (int i = 0; i < cometName.length(); i++) {
      int letter = cometName.charAt(i) - 'A' + 1;
      cometVal = (cometVal * letter) % 47;
    }

    int groupVal = 1;
    for (int i = 0; i < groupName.length(); i++) {
      int letter = groupName.charAt(i) - 'A' + 1;
      groupVal = (groupVal * letter) % 47;
    }

    if (cometVal == groupVal) {
      output.println("GO");
    } else {
      output.println("STAY");
    }
    output.close();
  }
}
