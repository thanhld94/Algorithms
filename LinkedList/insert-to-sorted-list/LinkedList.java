import java.util.Arrays;

public class LinkedList {
    ListNode head;
    
    private class ListNode {
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public LinkedList(int[] a) {
        Arrays.sort(a);
        head = new ListNode(a[0]);
        ListNode current = head;
        for (int i = 0; i < a.length; i++) {
            ListNode tmp = new ListNode(a[i]);
            current.next = tmp;
            current = current.next;
        }
    }

    public void insert(int num) {
        ListNode p = head;
        while (p.next != null) {
            if (p.val > num) {
                ListNode tmp = new ListNode(p.val);
                tmp.next = p.next;
                p.val = num;
                p.next = tmp;
                return;
            }
            p = p.next;
        }
        ListNode nNode = new ListNode(num);
        p.next = nNode;
    }

    public void print() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5,1,3,8,14,2,7,50};
        LinkedList list = new LinkedList(arr);
        list.insert(Integer.parseInt(args[0]));
        list.print();
    }
}
