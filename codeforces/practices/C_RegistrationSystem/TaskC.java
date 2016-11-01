import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    Trie trie = new Trie();

    int n = input.nextInt();
    for (int i = 0; i < n; i++) {
      String username = input.next();
      int count = trie.get(username);
      if (count == 0) {
        output.println("OK");
      } else {
        output.println(username + count);
      }
      trie.add(username);
    }
  }

  private class Trie {
    private TrieNode root = new TrieNode('$');

    private void add(String s) {
      TrieNode current = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        boolean found = false;
        for (TrieNode child : current.adj) {
          if (child.key == c) {
            found = true;
            current = child;
            break;
          }
        }
        if (!found) {
          TrieNode next = new TrieNode(c);
          current.adj.add(next);
          current = next;
        }
      }
      //System.out.println(current.key + " " + current.count);
      current.count++;
    }

    private int get(String s) {
      TrieNode current = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        boolean found = false;
        for (TrieNode child : current.adj) {
          if (child.key == c) {
            current = child;
            found = true;
            break;
          }
        }
        if (!found) {
          return 0;
        }
      }
      return current.count;
    }

    private class TrieNode {
      private char key;
      private int count;
      private List<TrieNode> adj;

      private TrieNode(char c) {
        key = c;
        count = 0;
        adj = new ArrayList<TrieNode>();
      }
    }
  }
}
