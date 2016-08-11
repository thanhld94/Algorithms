import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
  public static void main(String[] args) {
    TaskA ta = new TaskA();
    ta.solve(new Scanner(System.in), new PrintWriter(System.out));
  }

  public void solve(Scanner input, PrintWriter output) {
    String s = input.next();
    char[] nums = s.toCharArray();
    int[] count = new int[4];
    for (char num : nums) {
      if (num != '+') {
        count[num - '0']++;
      }
    }
    int idx = 1;
    for (int i = 0; i < nums.length; i += 2) {
      while (count[idx] == 0) idx++;
      nums[i] = (char) (idx + '0');
      count[idx]--;
    }
    output.println(new String(nums));
    output.close();
  }
}
