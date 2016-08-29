/*
ID: thanhld1
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

import java.util.Map.Entry;

public class gift1 {
  
  public static void main(String[] args) throws IOException{
    BufferedReader input = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    
    Map <String, Integer> map = new HashMap <String, Integer> ();
    String[] names = new String[n];
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String s = st.nextToken();
      map.put(s, 0);
      names[i] = s;
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String name = st.nextToken();
      st = new StringTokenizer(input.readLine());

      int total = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (num == 0) {
        map.put(name, map.get(name) + total);
        continue;
      }

      int amount = total / num;

      map.put(name, map.get(name) + total % num - total);
      
      for (int j = 0; j < num; j++) {
        st = new StringTokenizer(input.readLine());
        String receiver = st.nextToken();
        map.put(receiver, map.get(receiver) + amount);
      }
    }
    for (String name : names) {
      output.println(name + " " + map.get(name));
    }
    output.close();
  }
}
