import java.util.Hashtable;

public class LRUCache {
    private LinkedList data;
    private Hashtable<Integer, Node> map;
    private int capacity;

    public static void main(String[] args) {
        LRUCache lc = new LRUCache(4);
        lc.insert(1, "google.com");
        lc.insert(2, "facebook.com");
        lc.insert(3, "amazon.com");
        lc.insert(4, "microsoft.com");
        lc.insert(5, "24h.com.vn");
        System.out.println("Get record with key 3 = " + lc.get(3).value);
        lc.data.print();
        System.out.println("Get record with key 4 = " + lc.get(4).value);
        lc.data.print();
        lc.insert(7, "google.com");
    }

    public LRUCache(int maxSize) {
        capacity = maxSize;
        data = new LinkedList();
        map = new Hashtable<Integer, Node>();
    }

    public void insert(int key, String s) {
        Node p = new Node(key, s);
        if (data.size >= capacity) {
            map.remove(data.last.key);
            data.remove(data.last);
        }
        map.put(key, p);
        data.addToHead(p);
        data.print();
    }

    public Node get(int key) {
        Node p = map.get(key);
        if (p == null) { // not in cache
            return null;
        }
        data.pushToFront(p);
        return p;
    }

    private class LinkedList {
        private Node head;
        private Node last;
        private int size;

        private LinkedList() {
            head = last = null;
            size = 0;
        }

        private void addToHead(Node p) {
            size++;
            if (head == null) {
                head = last = p;
                return;
            }
            p.next = head;
            head.previous = p;
            head = p;
        }

        private void remove(Node p) {
            if (head == null) return;
            size--;
            if (p == head) {
                head = head.next;
                head.previous = null;
                return;
            }
            if (p == last) {
                last = p.previous;
                last.next = null;
                p.previous = null;
                return;
            }
            // normal case
            p.previous.next = p.next;
            p.next.previous = p.previous;
            p.next = null;
            p.previous = null;
        }

        private void pushToFront(Node p) {
            remove(p);
            addToHead(p);
        }
        
        private void print() {
            Node p = head;
            System.out.println("Cache list: ");
            while (p != null) {
                System.out.println("key = " + p.key + " value = " + p.value);
                p = p.next;
            }
            System.out.println();
        }

    }
    private class Node {
        private Node next;
        private Node previous;
        private String value;
        private int key;

        private Node(int key, String value) {
            previous = next = null;
            this.value = value;
            this.key = key;
        }
    }
}
