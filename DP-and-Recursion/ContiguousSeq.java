import java.util.PriorityQueue;

public class ContiguousSeq {
    private int[] seq;
    private int[] sum;
    public static final int MIN_VAL = -1 * (1 << 31);

    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);
        ContiguousSeq cs = new ContiguousSeq(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("Maximum sum interval is: " + cs.getMaxInterval());
    }

    public ContiguousSeq(int[] arr) {
        seq = new int[arr.length];
        for (int i = 0; i < seq.length; i++)
            seq[i] = arr[i];
    }

    private void initializeSum() {
        sum = new int[seq.length];
        sum[0] = seq[0];
        for(int i = 1; i < seq.length; i++) {
            sum[i] = sum[i-1] + seq[i];
        }
    }

    private int getMaxInterval() {
        int result = MIN_VAL;
        initializeSum();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(0);
        for (int i = 0; i < sum.length; i++) {
            if (result < sum[i] - heap.peek()) {
                result = sum[i] - heap.peek();
            }
            heap.add(sum[i]);
        }
        return result;
    }
    
}
