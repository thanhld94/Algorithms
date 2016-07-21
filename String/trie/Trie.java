import java.util.ArrayList;

public class Trie {
    private Node root;

    public static void main(String[] args) {
        Trie document = new Trie();
        for (int i = 0; i < args.length; i++) {
            document.addWord(args[i]);
        };
        for (int i = 0; i < args.length; i++) {
            System.out.println("The word '" + args[i] + "' appeared: " + document.findWord(args[i]) + " times.");
        }
    }

    public Trie() {
        root = new Node(null);
    }

    public int findWord(String s) {
        Node p = this.root;
        for (int i = 0; i < s.length(); i++) {
            boolean foundNode = false;
            for (Node child : p.adj) {
                if (child.key == s.charAt(i)) {
                    foundNode = true;
                    p = child;
                    break;
                }
            }
            if (!foundNode) {
                return 0;
            }
        }
        return p.wordsCount;
    }

    public void addWord(String s) {
        Node p = this.root;
        for (int i = 0; i < s.length(); i++) {
            boolean foundNode = false;
            for (Node child : p.adj) {
                if (child.key == s.charAt(i)) {
                    foundNode = true;
                    p = child;
                    break;
                }
            }
            if (!foundNode) {
                Node newNode = new Node(s.charAt(i));
                p.adj.add(newNode);
                p = newNode;
            }
        }
        if (p != this.root) {
            p.wordsCount++;
        }
    }

    private class Node {
        private Character key;
        private ArrayList<Node> adj;
        private int wordsCount;

        public Node(Character c) {
            wordsCount = 0;
            key = c;
            adj = new ArrayList<Node>();
        }
    }
}
