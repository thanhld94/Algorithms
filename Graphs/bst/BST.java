import java.util.Queue;
import java.util.LinkedList;

public class BST {
    private Node root;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5,"google");
        bst.insert(2,"amazon");
        bst.insert(4,"microsoft");
        bst.insert(1,"linkedin");
        bst.insert(3,"apple");
        bst.insert(5,"hello");
        bst.printTree();
        System.out.println("Get 3 = " + bst.get(3).data);
        System.out.println("Get 5 = " + bst.get(5).data);
    }

    public BST() {
        root = null;
    }
    
    public void printTree() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int currentLv = 1;
        int nextLv = 0;
        while (q.size() != 0) {
            Node u = q.poll();
            currentLv--;
            if (u == null)
                System.out.print("null ");
            else { 
                System.out.print(u.key + " ");
                q.add(u.left);
                q.add(u.right);
                nextLv += 2;
            }
            if (currentLv == 0) {
                System.out.println();
                currentLv = nextLv;
                nextLv = 0;
            }
        }
    }

    public void insert(int key, String s) {
        Node p = new Node(key, s);
        if (root == null) {
            root = p;
            return;
        }

        Node current = root;
        Node lastNode = root;

        while (current != null) {
            lastNode = current;
            if (current.key >= key) 
                current = current.left;
            else 
                current = current.right;
        }
        
        if (lastNode.key >= key)
            lastNode.left = p;
        else 
            lastNode.right = p;
    }

    public Node get(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            if (current.key > key)
                current = current.left;
            else 
                current = current.right;
        }
        return null;
    }
    
    private class Node {
        private int key;
        private String data;
        private Node left, right;

        private Node(int key, String s) {
            this.key = key;
            this.data = s;
            left = right = null;
        }
    }
}
