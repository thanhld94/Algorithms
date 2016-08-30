/*
ID: thanhld1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {
  private static final char[][] NUM = {{'A', 'B', 'C'}, 
                                       {'D', 'E', 'F'}, 
                                       {'G', 'H', 'I'}, 
                                       {'J', 'K', 'L'}, 
                                       {'M', 'N', 'O'}, 
                                       {'P', 'R', 'S'}, 
                                       {'T', 'U', 'V'}, 
                                       {'W', 'X', 'Y'}};

  private Set <String> names;
  private List <String> result;
  private char[] current;

  public static void main(String[] args) throws IOException {
    namenum sol = new namenum();
    sol.solve();
  }

  public void solve() throws IOException {
    initDict();
    result = new ArrayList<String>();
    
    BufferedReader input = new BufferedReader(new FileReader("namenum.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
    String seq = input.readLine();
    current = new char[seq.length()];
    for (int i = 0; i < seq.length(); i++) {
      if (seq.charAt(i) == '0' || seq.charAt(i) == '1') {
        output.println("NONE");
        output.close();
        return;
      }
    }
    gen(0, seq);
    if (result.size() == 0) {
      output.println("NONE");
      output.close();
      return;
    }

    Collections.sort(result);
    for (String res : result) {
      output.println(res);
    }
    output.close();
  }

  private void initDict() throws IOException {
    names = new HashSet<String>();

    BufferedReader dictin = new BufferedReader(new FileReader("dict.txt"));
    String line = dictin.readLine();
    while (line != null) {
      names.add(line);
      line = dictin.readLine();
    }
  }

  private void gen(int idx, String seq) {
    if (idx == seq.length()) {
      String s = new String(current);
      if (names.contains(s)) {
        result.add(s);
      }
      return;
    }

    int val = seq.charAt(idx) - '2';
    for (char c : NUM[val]) {
      current[idx] = c;
      gen(idx + 1, seq);
    }
  }
}
