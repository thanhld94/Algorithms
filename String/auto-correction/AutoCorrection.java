import java.util.ArrayList;

public class AutoCorrection {
    private Trie trie;
   
    public static void main(String[] args) {
        String[] dict = {"tree", "urge", "define", "used", "tred", "test", "uses", "mongo"};
        int[] num = {8,7,3,3};
        AutoCorrection ac = new AutoCorrection();
        ArrayList<String> result = ac.getPossible(num, dict);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    public ArrayList<String> getPossible(int[] num, String[] dict) {
        initDict(dict);
        return trie.get(num);
    }

    private void initDict(String[] dict) {
        trie = new Trie();
        for (int i = 0; i < dict.length; i++) 
            trie.insert(dict[i]);
    }
    
    private class Trie {
        private Node root = new Node();

        private void insert(String s) {
            Node p = root;
            for (int i = 0; i < s.length(); i++) {
                int num = getNum(s.charAt(i));
                if (p.adj[num] == null) {
                    Node v = new Node();
                    p.adj[num] = v;
                }
                p = p.adj[num];
            }
            p.wordList.add(s);
        }

        private ArrayList<String> get(int[] num) {
            Node p = root;
            for (int i = 0; i < num.length; i++) {
                if (p.adj[num[i]] == null) 
                    return null;
                p = p.adj[num[i]];
            }
            return p.wordList;
        }

        private int getNum(char c) {
            if ('a' <= c && c <= 'c') 
                return 2;
            if ('d' <= c && c <= 'f')
                return 3;
            if ('g' <= c && c <= 'i')
                return 4;
            if ('j' <= c && c <= 'l')
                return 5;
            if ('m' <= c && c <= 'o')
                return 6;
            if ('p' <= c && c <= 's')
                return 7;
            if ('t' <= c && c <= 'v')
                return 8;
            if ('w' <= c && c <= 'z')
                return 9;
            return -1;
        }
        
        private class Node {
            private Node[] adj;
            private ArrayList<String> wordList;

            private Node() {
                adj = new Node[10];
                wordList = new ArrayList<String>();
            }
        }
    }
}
