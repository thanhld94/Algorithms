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
    int m = input.nextInt();
    Room[][] rooms = new Room[n][m];
    for (int i = 0; i < n; i++) {
      char[] row = input.next().toCharArray();
      for (int j = 0; j < m; j++) {
        rooms[i][j] = new Room(row[j]);
      }
    }

    int sr = input.nextInt() - 1;
    int sc = input.nextInt() - 1;
    int fr = input.nextInt() - 1;
    int fc = input.nextInt() - 1;
    int result = bfs(sr, sc, fr, fc, n, m, rooms);
    output.println(result);
  }

  private int bfs(int sr, int sc, int fr, int fc, int n, int m, Room[][] rooms) {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    Queue<Triple> queue = new LinkedList<Triple>();
    int[][][] d = new int[n][m][4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Arrays.fill(d[i][j], -1);
      }
    }
    queue.add(new Triple(sr,sc,0));
    d[sr][sc][0] = 0;
    while (queue.size() > 0) {
      Triple top = queue.poll();
      int row = top.row;
      int col = top.col;
      int rotated = top.rotated;
      if (row == fr && col == fc) {
        return d[row][col][rotated];
      }

      // try pressing the button
      {
        int newRotated = (rotated + 1) % 4;
        if (d[row][col][newRotated] == -1) {
          d[row][col][newRotated] = d[row][col][rotated] + 1;
          queue.add(new Triple(row, col, newRotated));
        }
      }

      // try to go to other rooms 
      {
        for (int dir = 0; dir < 4; dir++) {
          int newRow = row + dx[dir];
          int newCol = col + dy[dir];
          if (validMove(row, col, rotated, newRow, newCol, dir, rooms)
                && d[newRow][newCol][rotated] == -1) {
            d[newRow][newCol][rotated] = d[row][col][rotated] + 1;
           queue.add(new Triple(newRow, newCol, rotated));
          }
        }
      }
    }
    return -1;
  }

  private boolean validMove(int row, int col, int rotated, int newRow, int newCol, int dir, Room[][] rooms) {
    if (newRow < 0 || newRow >= rooms.length || newCol < 0 || newCol >= rooms[0].length) 
      return false;
    if (!rooms[row][col].hasDoor(dir, rotated)) 
      return false;
    if (!rooms[newRow][newCol].hasDoor((dir + 2) % 4, rotated))
      return false;
    return true;
  }

  private class Room {
    private static final int UP = 0;
    private static final int LEFT = 1;
    private static final int DOWN = 2;
    private static final int RIGHT = 3;

    private boolean[] door;

    private Room(char status) {
      door = new boolean[4];
      switch(status) {
        case '+':
          Arrays.fill(door, true);
          break;
        case '-':
          door[LEFT] = door[RIGHT] = true;
          break;
        case '|':
          door[UP] = door[DOWN] = true;
          break;
        case '^':
          door[UP] = true;
          break;
        case 'v':
          door[DOWN] = true;
          break;
        case '<':
          door[LEFT] = true;
          break;
        case '>':
          door[RIGHT] = true;
          break;
        case 'U':
          door[RIGHT] = door[LEFT] = door[DOWN] = true;
          break;
        case 'D':
          door[UP] = door[LEFT] = door[RIGHT] = true;
          break;
        case 'L':
          door[UP] = door[RIGHT] = door[DOWN] = true;
          break;
        case 'R':
          door[UP] = door[LEFT] = door[DOWN] = true;
          break;
      }
    }
    
    private boolean hasDoor(int dir, int rotation) {
      int idx = (dir + rotation) % 4;
      return door[idx];
    }
  }

  private class Triple {
    private int row;
    private int col;
    private int rotated;

    private Triple(int row, int col, int rotated) {
      this.row = row;
      this.col = col;
      this.rotated = rotated;
    }
  }
}
