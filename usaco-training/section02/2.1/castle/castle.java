/*
ID: thanhld1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle {
  
  // W N E S
  private final int[] dx = {0, -1, 0, 1};
  private final int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("castle.in"));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
    castle sol = new castle();
    sol.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    StringTokenizer st = new StringTokenizer(input.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[][] walls = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      for (int j = 0; j < m; j++) {
        walls[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // index room numbers
    int[][] connections = new int[n][m];
    int[] roomSizes = new int[n * m];
    int numConnects = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (connections[i][j] == 0) { // not visited yet
          numConnects++;
          roomSizes[numConnects - 1] = dfs(i, j, walls, connections, numConnects);
        }
      }
    }

    // get size of the biggest room
    int maxSize = 0;
    for (int size : roomSizes) {
      maxSize = Math.max(maxSize, size);
    }
    output.println(numConnects);
    output.println(maxSize);
  
    GraphNode[] nodes = initGraph(connections, roomSizes, numConnects);
    
    // get maximum size of two combine room
    int combineMax = 0;
    for (GraphNode node : nodes) {
      for (int con : node.adj) {
        combineMax = Math.max(combineMax, node.value + nodes[con].value);
      }
    }
    output.println(combineMax);

    // print the connecting wall
    for (int col = 0; col < m; col++) {
      for (int row = n - 1; row >= 0; row--) {
        for (int dir = 0; dir < 3; dir++) {
          int nrow = row + dx[dir];
          int ncol = col + dy[dir];
          if (validSquare(nrow, ncol, n, m) && connections[nrow][ncol] != connections[row][col]) {
            int src = connections[row][col] - 1;
            int dest = connections[nrow][ncol] - 1;
            if (nodes[src].value + nodes[dest].value == combineMax) {
              if (dir == 1) {
                output.println((row + 1) + " " + (col + 1) + " N");
                return;
              } else if (dir == 2) {
                output.println((row + 1) + " " + (col + 1) + " E");
                return;
              }
            }
          }
        }
      }
    }
  }

  private int dfs(int row, int col, int[][] walls, int[][] connections, int idx) {
    connections[row][col] = idx;
    int total = 1;
    for (int dir = 0; dir < 4; dir++) {
      int nrow = row + dx[dir];
      int ncol = col + dy[dir];
      if (validSquare(nrow, ncol, walls.length, walls[0].length)) {
        if (connections[nrow][ncol] == 0 && (walls[row][col] & (1 << dir)) == 0) { //have not visited && no wall at that direction
          total += dfs(nrow, ncol, walls, connections, idx);
        }
      }
    }
    return total;
  }

  private boolean validSquare(int row, int col, int numRow, int numCol) {
    return (0 <= row && row < numRow && 0 <= col && col < numCol);
  }

  private GraphNode[] initGraph(int[][] connections, int[] roomSize, int numConnects) {
    GraphNode[] nodes = new GraphNode[numConnects];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new GraphNode(roomSize[i]);
    }

    for (int row = 0; row < connections.length; row++) {
      for (int col = 0; col < connections[0].length; col++) {
        for (int dir = 0; dir < 4; dir++) {
          int nrow = row + dx[dir];
          int ncol = col + dy[dir];
          if (validSquare(nrow, ncol, connections.length, connections[0].length)) {
            if (connections[row][col] != connections[nrow][ncol]) {
              int src = connections[row][col] - 1;
              int dest = connections[nrow][ncol] - 1;
              nodes[src].adj.add(dest);
              nodes[dest].adj.add(src);
            }
          }
        }
      }
    }
    return nodes;
  }

  private class GraphNode {
    private Set<Integer> adj;
    private int value;

    private GraphNode(int roomSize) {
      adj = new HashSet<Integer>();
      value = roomSize;
    }
  }
}
