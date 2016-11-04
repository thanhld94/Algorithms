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
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    Set<Integer> b = new HashSet<Integer>();
    for (int i = 0; i < m; i++) {
      int num = input.nextInt();
      b.add(num);
    }

    int[] gcd = new int[n];
    gcd[0] = a[0];
    for (int i = 1; i < n; i++) {
      gcd[i] = getGcd(gcd[i - 1], a[i]);
    }

    for (int i = n - 1; i >= 0; i--) {
      int delta = getCount(gcd[i], b);
      if (delta < 0) { // # bad > # good
        for (int j = 0; j <= i; j++) // update a
          a[j] /= gcd[i];
        for (int j = 0; j <= i; j++) // update previous gcds
          gcd[j] /= gcd[i];
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      int delta = getCount(a[i], b);
      result = result + delta;
    }
    output.println(result);
  }

  private int getGcd(int a, int b) {
    if (a % b == 0) return b;
    return getGcd(b, a % b);
  }

  private int getCount(int x, Set<Integer> bad) {
    int countBad = 0;
    int countGood = 0;
    while (x % 2 == 0) {
      if (bad.contains(2))
        countBad++;
      else 
        countGood++;
      x /= 2;
    }
    for (int num = 3; num * num <= x; num += 2) {
      while (x % num == 0) {
        if (bad.contains(num))
          countBad++;
        else
          countGood++;
        x /= num;
      }
    }
    if (x > 1 && bad.contains(x)) 
      countBad++;
    else if (x > 1) 
      countGood++;
    return countGood - countBad;
  }
}
