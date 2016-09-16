import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Main mn = new Main();
    mn.solve(input, output);
    output.close();
  }

  public void solve(BufferedReader input, PrintWriter output) throws IOException {
    String line = input.readLine();
    StringTokenizer st;
    while (line != null) {
      st = new StringTokenizer(line);
      int y = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(input.readLine());
      int p = Integer.parseInt(st.nextToken());
      int[] pope = new int[p];
      for (int i = 0; i < p; i++) {
        st = new StringTokenizer(input.readLine());
        pope[i] = Integer.parseInt(st.nextToken());
      }
      getResult(y - 1, p, pope, output);
      line = input.readLine();
      if (line == null) {
        break;
      }
      line = input.readLine();
    }
  }

  private void getResult(int y, int p, int[] pope, PrintWriter output) {
    int startYear = pope[0];
    int resultCount = 1;
    int resultLastIdx = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    heap.add(pope[0]);
    for (int i = 1; i < p; i++) {
      while (pope[i] - heap.peek() > y) {
        heap.poll();
      }
      heap.add(pope[i]);
      if (resultCount < heap.size()) {
        resultCount = heap.size();
        resultLastIdx = i;
      }
    }

    int resultFirstIdx = resultLastIdx;
    while (resultFirstIdx > 0 && pope[resultLastIdx] - pope[resultFirstIdx - 1] <= y) {
      resultFirstIdx--;
    }
    output.println(resultCount + " " + pope[resultFirstIdx] + " " + pope[resultLastIdx]);
  }
}
