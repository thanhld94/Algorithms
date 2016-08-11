import java.util.Scanner;
import java.io.PrintWriter;

public class TaskC {
  public static void main(String[] args) {
    TaskC tc = new TaskC();
    tc.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    int numApp = input.nextInt();
    int numQuery = input.nextInt();
    MessageSystem ms = new MessageSystem(numApp, numQuery);
    for (int i = 0; i < numQuery; i++) {
      int query = input.nextInt();
      int data = input.nextInt();
      if (query == 1) {
        ms.addApp(data);
        output.println(ms.total);
      } else if (query == 2) {
        ms.deleteApp(data);
        output.println(ms.total);
      } else {
        ms.removeInterval(data);
        output.println(ms.total);
      }
    }
    output.close();
  }

  private class MessageSystem {
    int total;
    int[] apps;
    int[] delayapp;
    int last;
    int[] timeline;
    int timeIdx;

    private MessageSystem(int numApp, int numQuery) {
      apps = new int[numApp + 1];
      delayapp = new int[numApp + 1];
      timeline = new int[numQuery];
      total = 0;
      last = 0;
      timeIdx = 0;
    }

    private void addApp(int x) {
      apps[x]++;
      delayapp[x]++;
      timeline[timeIdx++] = x;
      total++;
    }

    private void deleteApp(int x) {
      total -= apps[x];
      apps[x] = 0;
    }

    private void removeInterval(int t) {
      t = Math.min(timeIdx, t);
      for (int i = last; i < t; i++) {
        int x = timeline[i];
        delayapp[x]--;
        if (delayapp[x] < apps[x]) {
          total--;
          apps[x]--;
        }
      }
      if (last < t) 
        last = t;
    }
  }
}
