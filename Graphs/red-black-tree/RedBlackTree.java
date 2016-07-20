public class RedBlackTree {
    private static final int RED = 0;
    private static final int BLACK = 1;
    Node root;
    Node nil = new Node(null, BLACK);

    public RedBlackTree() {
        this.root = this.nil;
    }

    public void insertRB(int key) {
        Node z = new Node(key, RED);
        Node y = this.nil;
        Node x = this.root;
        while (x != this.nil) {
            y = x;
            if (z.value < x.value) { 
                x = x.left;
            } else { 
                x = x.right;
            }
        }
        z.p = y;
        if (y.p == this.nil) {
            this.root = z;
        } else if (z.value < y.value) {
            y.left = z;
        } else 
            y.right = z;
        updateRB(z);
    }

    private void updateRB(Node z) {
        while (z.p.color == RED) {
            if (z.p == z.p.p.right) {
                Node y = z.p.p.left;
                if (y.color == RED) { //Case 1: Uncle is also RED
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                    z = z.p.p;
                } else { // Uncle is BLACK
                    if (z == z.p.left) { //Case 2: Unbalanced Right - Left 
                        z = z.p;
                        rotateRight(z);
                    } 
                    // Case 3: Unbalanced Right - Right
                    z.p.p.color = RED;
                    z.p.color = BLACK;
                    rotateLeft(z.p.p);
                }
            } else {
                Node y = z.p.p.right;
                if (y.color == RED) { // Case 1: Uncle is also RED
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                    z = z.p.p;
                } else { // Uncle is BLACK
                    if (z == z.p.right) { // Unbalance Left-Right
                        z = z.p;
                        rotateLeft(z);
                    }
                    // Case 3: Unbalanced Left-Left
                    z.p.p.color = RED;
                    z.p.color = BLACK;
                    rotateRight(z.p.p);
                }
            }
        }
        this.root.color = BLACK;
    }

    private boolean rotateLeft(Node x) {
        if (x.right == this.nil) return false;
        Node y = x.right;
        x.right = y.left;
        if (y.left != this.nil) {
            y.left.p = x;
        }
        
        y.p = x.p;
        if (x.p == this.nil) {
            this.root = y;
        } else if (x.p.right == x) {
            x.p.right = y;
        } else {
            x.p.left = y;
        }
        
        y.left = x;
        x.p = y;
        return true;
    }

    private boolean rotateRight(Node x) {
        if (x.left == this.nil) return false;
        Node y = x.left;
        x.left = y.right;
        if (y.right != this.nil) {
            y.right.p = x;
        }

        y.p = x.p;
        if (x.p == this.nil) {
            this.root = y;
        } else if (x.p.right == x) {
            x.p.right = y;
        } else {
            x.p.left = y;
        }

        y.right = x;
        x.p = y;
        return true;
    }

    private class Node {
        private Node left, right, p;
        private Integer value;
        private int color;

        private Node(Integer x, int color) {
            left = right = p = null;
            value = x;
            color = BLACK;
        }
    }
}
