import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskB {

  public static void main(String[] args) {
    TaskB tb = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tb.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int nbars = input.nextInt();
    int[] prices = new int[nbars];
    for (int i = 0; i < nbars; i++) {
      prices[i] = input.nextInt();
    }
    Arrays.sort(prices);

    int ndays = input.nextInt();
    for (int i = 0; i < ndays; i++) {
      int money = input.nextInt();
      int result = binarysearch(prices, money);
      output.println(result);
    }
  }

  private int binarysearch(int[] prices, int money) {
    int l = 0;
    int r = prices.length - 1;
    int result = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (prices[mid] <= money) {
        result = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return result + 1;
  }
}
