import java.util.ArrayList;

public class Heap {

    public static void main(String[] args) {
        int[] a = new int[args.length];
        for (int i = 0; i < a.length; i++) 
            a[i] = Integer.parseInt(args[i]);
        Heap h = new Heap();
        for (int i = 0; i < a.length; i++) {
            h.add(a[i]);
            System.out.println("Added + " + a[i] + ", min = " + h.peek());
        }

        System.out.println(h.pull() + " " + h.pull());
    }

    private ArrayList<Integer> heap;
    private int len;

    public Heap() {
        len = 0;
        heap = new ArrayList<Integer>();
    }

    public int size() {
        return len;
    }

    public Integer peek() {
        if (len == 0) return null;
        return heap.get(0);
    }

    public void add(int x) {
        heap.add(x);
        len++;
        bubleUp(len-1);
    }

    private void bubleUp(int idx) {
        if (parent(idx) != null && heap.get(idx) < heap.get(parent(idx))) {
            swap(idx, parent(idx));
            bubleUp(parent(idx));
        }
    }

    private Integer parent(int idx) {
        if (idx == 0) return null;
        else return idx/2;
    }

    private boolean swap(int idx1, int idx2) {
        if (idx1 >= len || idx2 >= len) return false;
        int tmp = heap.get(idx1);
        heap.set(idx1,heap.get(idx2));
        heap.set(idx2,tmp);
        return true;
    }
    
    public Integer pull() {
        if (len == 0) return null;
        int result = heap.get(0);
        swap(0, len-1);
        heap.remove(--len);
        updateHeap(0);
        return result;
    }

    private void updateHeap(int idx) {
        int child = idx * 2 + 1;
        if (child >= len) return;
        if (child + 1 < len && heap.get(child) > heap.get(child+1))
            child++;
        if (heap.get(child) < heap.get(idx)) {
            swap(idx, child);
            updateHeap(child);
        }
    }
}
