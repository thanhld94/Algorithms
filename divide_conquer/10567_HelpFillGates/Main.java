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
    StringTokenizer st = new StringTokenizer(input.readLine());
    String text = st.nextToken();
    Map <Character, List<Integer> > map = new HashMap <Character, List<Integer> >();
    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      char cap = (char) ('A' + i);
      map.put(c, new ArrayList<Integer>());
      map.put(cap, new ArrayList<Integer>());
    }

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      map.get(c).add(i);
    }

    st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine());
      String query = st.nextToken();
      getOutput(map, query, output);
    }
  }

  private void getOutput(Map <Character, List<Integer> > map, String query, PrintWriter output) {
    String result = "Matched ";
    int last = -1;
    for (int i = 0; i < query.length(); i++) {
      char letter = query.charAt(i);
      int position = binarySearch(map.get(letter), last);
      if (position == -1) {
        output.println("Not matched");
        return;
      } else {
        if (i == 0 || i == query.length() - 1) {
          result += position;
        }
        if (i == 0) {
          result += ' ';
        }
        last = position;
      }
    }
    output.println(result);
  }

  // find the first number that is greater than value in a sorted list
  private int binarySearch(List<Integer> list, int value) {
    int l = 0;
    int r = list.size() - 1;
    int result = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (list.get(mid) > value) {
        result = list.get(mid);
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return result;
  }
}
