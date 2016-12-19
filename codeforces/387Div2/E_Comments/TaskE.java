import java.io.*;
import java.util.*;

public class TaskE {
  public static void main(String[] args) {
    TaskE tE = new TaskE();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tE.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    String text = in.next();
    String[] fields = text.split(",");
    int n = fields.length / 2;
    String[] comments = new String[n];
    int[] nchilds = new int[n];
    // parse input
    for (int i = 0; i < n; i++) {
      comments[i] = fields[i * 2];
      nchilds[i] = Integer.parseInt(fields[i * 2 + 1]);
    }
    List<List<String>> commentTree = new ArrayList<List<String>>();
    int current = 0;
    while (current < n) {
      current = process(current, comments, nchilds, commentTree, 1);
    }
    out.println(commentTree.size());
    for (List<String> list : commentTree) {
      for (String comment : list) {
        out.print(comment + " ");
      }
      out.println();
    }
  }

  private int process(int idx, String[] comments, int[] nchilds, List<List<String>> commentTree, int depth) {
    if (commentTree.size() < depth) {
      commentTree.add(new ArrayList<String>());
    }
    commentTree.get(depth - 1).add(comments[idx]);
    int next = idx + 1;
    for (int i = 0; i < nchilds[idx]; i++) {
      next = process(next, comments, nchilds, commentTree, depth + 1);
    }
    return next;
  }

  private static class BScanner {
    private BufferedReader input;
    private StringTokenizer st;

    private BScanner() {
      input = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(input.readLine());
        } catch (IOException e) {
          System.err.println("No more token");
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    private int nextInt() {
      return Integer.parseInt(next());
    }

    private long nextLong() {
      return Long.parseLong(next());
    }

    private double nextDouble() {
      return Double.parseDouble(next());
    }

    private String nextLine() {
      String line = "";
      try {
        line = input.readLine();
      } catch (Exception e) {
        System.err.println("No more lines");
        e.printStackTrace();
      }
      return line;
    }
  }
}
