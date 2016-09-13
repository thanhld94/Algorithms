import java.io.PrintWriter;
import java.util.*;

public class TaskC {

  private static final int BASE = 19;

  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    Trie trie = new Trie();
    
    for (int i = 0; i < n; i++) {
      String query = input.next();
      String val = extendAndReverse(input.next(), BASE);
      if (query.equals("+")) { // insert
        trie.add(val);
      } else if (query.equals("-")) { // remove
        trie.remove(val);
      } else { // count
        output.println(trie.get(val));
      }
    }
  }

  private String extendAndReverse(String s, int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    for (int i = 0; i < (length - s.length()); i++) {
      sb.append('0');
    }
    return sb.toString();
  }

  private class Trie {
    private Node root;

    private Trie() {
      root = new Node();
    }

    private void add(String s) {
      Node current = root;
      for (int i = 0; i < s.length(); i++) {
        int parity = ((s.charAt(i) - '0') % 2 == 0) ? 0 : 1;
        if (current.child[parity] == null) {
          Node next = new Node();
          current.child[parity] = next;
        }
        current = current.child[parity];
      }

      if (current.map.containsKey(s)) {
        int val = current.map.get(s);
        current.map.put(s, val + 1);
      } else {
        current.map.put(s, 1);
      }
      current.count++;
    }

    private void remove(String s) {
      Node current = root;
      for (int i = 0; i < s.length(); i++) {
        int parity = ((s.charAt(i) - '0') % 2 == 0) ? 0 : 1;
        current = current.child[parity];
      }

      current.count--;
      int val = current.map.get(s);
      current.map.put(s, val - 1);
    }

    private int get(String s) {
      Node current = root;
      for (int i = 0; i < s.length(); i++) {
        int parity = ((s.charAt(i) - '0') % 2 == 0) ? 0 : 1;
        if (current.child[parity] == null) {
          return 0;
        }
        current = current.child[parity];
      }
      return current.count;
    }

    private class Node {
      Node[] child;
      Map <String, Integer> map;
      int count;

      private Node() {
        child = new Node[2];
        child[0] = child[1] = null;
        map = new HashMap <String, Integer> ();
        count = 0;
      }
    }
  }
}
