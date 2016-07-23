public class IntervalTree {
    
    public static final int MIN_VAL = - (1 << 31);

    private Node root;

    public static void main(String[] args) {
        IntervalTree it = new IntervalTree(1,10);
        it.addInterval(1,4,3);
        it.addInterval(3,9,2);
        it.addInterval(8,10,1);
        it.addInterval(4,9,5);
        System.out.println("max in 1-10: " + it.getMax(1,10));
        System.out.println("max in 7,10: " + it.getMax(7,10));
        System.out.println("max in 1,3: " + it.getMax(1,3));
    }

    public IntervalTree(int low, int high) {
        root = new Node(low, high);
    }

    public void addInterval(int low, int high, int value) {
        update(root, low, high, value);
    }

    public int getMax(int low, int high) {
        return get(root, low, high);
    }

    private void update(Node p, int low, int high, int value) {
        if (p.low > high || p.high < low) return;
        if (low <= p.low && p.high <= high) {
            p.lazy = value;
            p.key += value;
            return;
        }
        
        if (p.left == null) p.left = new Node(p.low, (p.low + p.high)/2);
        if (p.right == null) p.right = new Node((p.low + p.high)/2 + 1, p.high);
        
        if (p.lazy > 0) {
            lazyUpdate(p);
        }
        update(p.left, low, high, value);
        update(p.right, low, high, value);
        p.key = Math.max(p.left.key, p.right.key);
    }

    private int get(Node p, int low, int high) {
        if (p.low > high || p.high < low) return MIN_VAL;
        if (low <= p.low && p.high <= high) return p.key;
        
        if (p.left == null) p.left = new Node(p.low, (p.low + p.high)/2);
        if (p.right == null) p.right = new Node((p.low + p.high)/2 + 1, p.high);
        
        if (p.lazy > 0) {
            lazyUpdate(p);
        }
        int maxLeft = get(p.left, low, high);
        int maxRight = get(p.right, low, high);
        return Math.max(maxLeft, maxRight);
    }

    private void lazyUpdate(Node p) {
        p.left.lazy = p.lazy;
        p.right.lazy = p.lazy;
        p.left.key += p.lazy;
        p.right.key += p.lazy;
        p.lazy = 0;
    }

    private class Node {
        private int key;
        private int lazy;
        private Node left, right;
        private int low, high;

        public Node(int low, int high) {
            key = 0;
            lazy = 0;
            left = null;
            right = null;
            this.low = low;
            this.high = high;
        }
    }
}
