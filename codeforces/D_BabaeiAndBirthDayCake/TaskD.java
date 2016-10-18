import java.io.PrintWriter;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    long[] volumes = new long[n]; 
    for (int i = 0; i < n; i++) {
      int r = input.nextInt();
      int h = input.nextInt();
      volumes[i] = 1L * r * r * h;
    }

    int[] compressed = rr(volumes);
    int max_compress = 0;
    for (int val : compressed) {
      max_compress = Math.max(max_compress, val);
    }

    IntervalTree tree = new IntervalTree(max_compress);

    long[] dp = new long[n];
    long result = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      dp[i] = tree.get(0, compressed[i] - 1) + volumes[i];
      result = Math.max(result, dp[i]);
      tree.update(compressed[i], dp[i]);
    }
    output.println(Math.PI * result);
  }

  private int[] rr(long[] arr) {
    int[] result = new int[arr.length];
    Pair[] tmp = new Pair[arr.length];
    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = new Pair(arr[i], i);
    }
    Arrays.sort(tmp);
    int idx = 0;
    result[tmp[0].idx] = 0;
    for (int i = 1; i < tmp.length; i++) {
      if (tmp[i].val != tmp[i - 1].val) {
        idx++;
      }
      result[tmp[i].idx] = idx;
    }
    return result;
  }

  private class IntervalTree {
    private TreeNode root;

    private IntervalTree(int range) {
      root = new TreeNode(0, range);
    }

    private void update(int position, long value) {
      update(root, position, value);
    }

    private void update(TreeNode p, int position, long value) {
      if (position < p.begin || p.end < position) {
        return;
      }
      p.key = Math.max(p.key, value);
      if (p.begin == p.end) {
        return;
      }

      int mid = p.begin + (p.end - p.begin)/2;
      if (p.left == null) 
        p.left = new TreeNode(p.begin, mid);
      if (p.right == null) 
        p.right = new TreeNode(mid + 1, p.end);

      update(p.left, position, value);
      update(p.right, position, value);
      p.key = Math.max(p.left.key, p.right.key);
    }

    private long get(int left, int right) {
      return get(root, left, right);
    }

    private long get(TreeNode p, int left, int right) {
      if (right < p.begin || p.end < left) {
        return 0;
      }
      if (left <= p.begin && p.end <= right) {
        return p.key;
      }

      int mid = p.begin + (p.end - p.begin)/2;
      if (p.left == null) 
        p.left = new TreeNode(p.begin, mid);
      if (p.right == null) 
        p.right = new TreeNode(mid + 1, p.end);
      long maxLeft = get(p.left, left, right);
      long maxRight = get(p.right, left, right);
      return Math.max(maxLeft, maxRight);
    }

    private class TreeNode {
      private long key;
      private int begin;
      private int end;
      private TreeNode left;
      private TreeNode right;

      private TreeNode(int begin, int end) {
        this.begin = begin;
        this.end = end;
        key = 0L;
        left = right = null;
      }
    }
  }

  private class Pair implements Comparable<Pair> {
    private int idx;
    private long val;

    private Pair(long val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    @Override public int compareTo(Pair other) {
      if (val == other.val) return 0;
      return (val < other.val) ? -1 : 1;
    }
  }
}
