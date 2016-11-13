import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) a[i] = in.nextInt();
        Arrays.sort(a);
        long max = 0L;
        long min = 0L;
        for (int i = 0; i < 4; i++) {
            min += a[i];
            max += a[i + 1];
        }
        System.out.println(min + " " + max);
    }
}