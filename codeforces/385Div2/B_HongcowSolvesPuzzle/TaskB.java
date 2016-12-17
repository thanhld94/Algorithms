import java.io.*;
import java.util.*;

public class TaskB {
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tB.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] board = new char[n][m];
    for (int i = 0; i < n; i++) {
      board[i] = in.next().toCharArray();
    }
    // first row
    int start = 0;
    int end = -1;
    int row = 0;
    while (row < n) {
      start = 0;
      while (start < m && board[row][start] == '.') 
        start++;
      if (start == m) {
        row++;
        continue;
      }
      end = start;
      while (end < m && board[row][end] == 'X')
        end++;
      end--;
      break;
    }
    // no piece
    if (row == n) {
      out.println("NO");
      return;
    }
    // check last row
    int lastRow = n - 1;
    while (lastRow > row) {
      boolean found = false;
      for (int i = 0; i < m; i++) {
        if (board[lastRow][i] == 'X') {
          found = true;
          break;
        }
      }
      if (found) break;
      lastRow--;
    }
    // check if piece is rectangle
    for (int r = row + 1; r <= lastRow; r++) {
      if (!check(board[r], start, end, m)) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }

  private boolean check(char[] row, int start, int end, int m) {
    for (int i = 0; i < start; i++) 
      if (row[i] == 'X') return false;
    for (int i = start; i <= end; i++) 
      if (row[i] == '.') return false;
    for (int i = end + 1; i < m; i++) 
      if (row[i] == 'X') return false;
    return true;
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
