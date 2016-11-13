import java.io.*;
import java.util.*;

public class Solution {
    int n;
    int k;
    int[] x;

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        sol.solve(in, out);
        out.close();
    }
    
    private void solve(Scanner in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        process(out);
    }
    
    private void process(PrintWriter out) {
        int result = 0;
        int left = 0;
        while (left < n) {
            // find the center
            int center = left;
            while (center < n && x[center] - x[left] <= k) center++;
            center--;
            result++;
            
            // find the outer bound
            int right = center;
            while (right < n && x[right] - x[center] <= k) right++;
            left = right;
        }
        out.println(result);
    }
}
