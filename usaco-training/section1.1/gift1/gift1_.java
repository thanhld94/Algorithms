/*
ID: thanhld1
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

public class gift1_ {

  public static void main(String[] args) throws IOException {
    gift1_ sol = new gift1_();
    sol.solve();
  }

  public void solve() throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    
    Person[] persons = new Person[n];
    Map <String, Integer> map = new HashMap <String, Integer> ();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String name = st.nextToken();
      persons[i] = new Person(name);
      map.put(name, i);
    }
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String giver = st.nextToken();
      st = new StringTokenizer(input.readLine());
      int total = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      
      int idx = map.get(giver);
      if (num == 0) {
        persons[idx].money += total;
        continue;
      }
      persons[idx].money += (total % num - total);

      int amount = total / num;
      for (int j = 0; j < num; j++) {
        st = new StringTokenizer(input.readLine());
        String receiver = st.nextToken();
        int rIdx = map.get(receiver);
        persons[rIdx].money += amount;
      }
    }

    for (Person person : persons) {
      output.println(person.name + " " + person.money);
    }
    output.close();
  }

  private class Person {
    private int money;
    private String name;

    private Person(String name) {
      money = 0;
      this.name = name;
    }
  }
}
