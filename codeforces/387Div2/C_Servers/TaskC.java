import java.io.*;
import java.util.*;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tC.solve(in, out);
    out.close();
  }

  public void solve(BScanner in, PrintWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    Task[] tasks = new Task[q];
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      int k = in.nextInt();
      int d = in.nextInt();
      tasks[i] = new Task(t, k, d);
    }
    PriorityQueue<Server> available = new PriorityQueue<Server>();
    for (int i = 1; i <= n; i++) {
      available.add(new Server(i, 0));
    }
    PriorityQueue<Server> busy = new PriorityQueue<Server>();
    for (int i = 0; i < tasks.length; i++) {
      while (busy.size() > 0) {
        Server top = busy.poll();
        if (top.finishTime >= tasks[i].time) {
          busy.add(top);
          break;
        }
        top.finishTime = 0;
        available.add(top);
      }
      if (available.size() < tasks[i].amount) {
        out.println(-1);
        continue;
      }
      int result = 0;
      for (int j = 0; j < tasks[i].amount; j++) {
        Server top = available.poll();
        top.finishTime = tasks[i].time + tasks[i].duration - 1;
        busy.add(top);
        result += top.index;
      }
      out.println(result);
    }
  }

  private class Task {
    private int time;
    private int amount;
    private int duration;

    private Task(int t, int k, int d) {
      this.time = t;
      this.amount = k;
      this.duration = d;
    }
  }

  private class Server implements Comparable<Server> {
    private int index;
    private int finishTime;

    private Server(int index, int finishTime) {
      this.index = index;
      this.finishTime = finishTime;
    }

    @Override public int compareTo(Server other) {
      if (finishTime != other.finishTime) return finishTime - other.finishTime;
      return index - other.index;
    }
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
