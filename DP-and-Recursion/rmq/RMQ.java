public class RMQ {
    private int[] arr;
    private int[][] minInterval; // minInterval[i][j] = the index of the min value from i with length 2^j or (i -> i + (2^j) -1)
    private int[] log;

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 1, 5, 7, 6, 8, 9, 2};
        RMQ rmq = new RMQ(a);
        System.out.println("Min from 1 to 6 is: " + rmq.getRMQ(1,6) + " - " + a[rmq.getRMQ(1,6)]);
        System.out.println("Min from 6 to 9 is: " + rmq.getRMQ(6,9) + " - " + a[rmq.getRMQ(6,9)]);
    }

    public RMQ(int[] a) {
        arr = new int[a.length];
        for (int i = 0; i < a.length; i++) 
            arr[i] = a[i];
        log = getLog();
        minInterval = getMinInterval();
    }

    private int[] getLog() {
        int[] log = new int[arr.length + 1];
        log[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            log[i] = log[i - 1];
            if ( (1 << (log[i-1] + 1)) <= i )
                log[i] = log[i-1] + 1;
        }
        return log;
    }

    private int[][] getMinInterval() {
        int[][] min = new int[arr.length][log[arr.length] + 1];

        for (int i = 0; i < arr.length; i++) 
            min[i][0] = i;
        for (int j = 1; j <= log[arr.length]; j++) {
            for (int i = 0; i < arr.length; i++) 
                if (i + (1 << j) < arr.length) {
                    // if the minimum element in (i, i + 2^(j-1) - 1) is less than the minimum in (i + 2^(j-1), i + 2^j - 1) 
                    if (arr[min[i][j - 1]] < arr[min[i + (1 << (j-1))][j - 1]])
                        min[i][j] = min[i][j - 1];
                    else // otherwise, min from i + 2^(j-1) to i + 2^j -1 is smaller
                        min[i][j] = min[i + (1 << (j-1))][j - 1];
                }
        }
        return min;
    }

    public int getRMQ(int i, int j) { // get minimum 
        int l = log[j - i + 1];
        return Math.min(minInterval[i][l], minInterval[j - (1 << l) + 1][l]);
    }

}
