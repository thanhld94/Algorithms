import java.util.Hashtable;

public class LRUCache {
    private LinkedList data;
    private Hashtable<Integer, Node> map;
    private int capacity;

    public LRUCache(int maxSize) {
        capacity = maxSize;
        data = new LinkedList();
        map = new Hashtable<Integer, Node>();
    }

    public void insert(int key, String s) {
        Node p = new Node(s);
        if (data.size >= capacity) { 
            // TODO: remove from map!
            remove(data.last);
        }
    }

    public void access(int key) {
        Node p = map.get(key);
        if (p == null) { // not in cache
            return;
        }
        data.pushToFront(p);
    }

    private class LinkedList {
        private Node head;
        private Node last;
        private int size;

        private LinkedList() {
            head = last = null;
            size = 0;
        }

        private void add(String value) {
            size++;
            Node p = new Node(value);
            if (head == null) { //list is empty
                head = last = p;
                return;
            }
            last.next = p;
            p.previous = last;
            last = p;
        }

        private void addToHead(Node p) {
            size++;
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
    }
    private class Node {
        private Node next;
        private Node previous;
        private String value;

        private Node(String value) {
            previous = next = null;
            this.value = value;
        }
    }
}
