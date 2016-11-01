import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
  
  public static void main(String[] args) {
    TaskD td = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    td.solve(new Scanner(System.in), pw);
    pw.close();
  }
  
  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    Trie trie = new Trie();
    trie.add(0);
    for (int i = 0; i < n; i++) {
      String query = input.next();
      int val = input.nextInt();
      if (query.equals("+")) {
        trie.add(val);
      } else if (query.equals("-")) {
        trie.remove(val);
      } else {
        output.println(trie.search(val));
      }
    }
  }

  private class Trie {
    private TrieNode root = new TrieNode();

    private void add(int x) {
      TrieNode current = root;
      for (int i = 31; i >= 0; i--) {
        if (((1 << i) & x) != 0) {
          if (current.one == null) {
            current.one = new TrieNode();
          }
          current = current.one;
        } else {
          if (current.zero == null) {
            current.zero = new TrieNode();
          }
          current = current.zero;
        }
        current.count++;
        //current.count++;
      }
    }

    private int search(int x) {
      //System.out.println(x + ":");
      TrieNode current = root;
      int result = 0;
      for (int i = 31; i >= 0; i--) {
        if (((1 << i) & x) != 0) {
          if (current.zero != null && current.zero.count > 0) {
            //System.out.println(i + " " + current.zero.count);
            result += (1 << i);
            current = current.zero;
          } else {
            current = current.one;
          }
        } else {
          if (current.one != null && current.one.count > 0) {
            //System.out.println(i + " " + current.one.count);
            result += (1 << i);
            current = current.one;
          } else {
            current = current.zero;
          }
        }
      }
      return result;
    }

    private void remove(int x) {
      TrieNode current = root;
      for (int i = 31; i >= 0; i--) {
        if (((1 << i) & x) != 0) {
          current.one.count--;
          current = current.one;
        } else {
          current.zero.count--;
          current = current.zero;
        }
      }
    }

    private class TrieNode {
      private TrieNode one;
      private TrieNode zero;
      private int count;

      private TrieNode() {
        one = null;
        zero = null;
        count = 0;
      }
    }
  }
}
