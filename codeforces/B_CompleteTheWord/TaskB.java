import java.io.*;
import java.util.*;

public class TaskB {
  public static void main(String[] args) throws IOException {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new BufferedReader(new InputStreamReader(System.in)), pw);
    pw.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    String word = input.readLine();
    
    for (int i = 0; i < word.length() - 25; i++) {
      int[] mark = new int[26];
      boolean found = true;
      
      for (int j = 0; j < 26; j++) {
        char c = word.charAt(i + j);
        if (c != '?') {
          int letter = c - 'A';
          mark[letter]++;
          if (mark[letter] > 1) {
            found = false;
            break;
          }
        }
      }

      if (found) {
        for (int j = 0; j < i; j++) {
          char c = word.charAt(j);
          if (c != '?') {
            output.print(c);
          } else {
            output.print('A');
          }
        }
        for (int j = 0; j < 26; j++) {
          char c = word.charAt(i + j);
          if (c != '?') {
            output.print(c);
          } else {
            boolean check = false;    
            for (int k = 0; k < 26; k++) {
              if (mark[k] == 0) {
                mark[k] = 1;
                char letter = (char) (k + 'A');
                output.print(letter);
                check = true;
                break;
              }
            }
            if (!check) 
              output.print('A');
          }
        }
        for (int j = i + 26; j < word.length(); j++) {
          char c = word.charAt(j);
          if (c != '?') {
            output.print(c);
          } else {
            output.print('A');
          }
        }
        output.println();
        return;
      }
    }
    output.println(-1);
  }
}
