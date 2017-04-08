import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class TaskCBIG {
  public static void main(String[] args) {
    TaskCBIG tCBIG = new TaskCBIG();
    BScanner in = new BScanner();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    tCBIG.solve(in, out);
    out.close();
  }

  static final BigInteger ONE = BigInteger.ONE;
  static final BigInteger ZERO = BigInteger.ZERO;

  public void solve(BScanner in, PrintWriter out) {
    int test = in.nextInt();
    for (int t = 1; t <= test; t++) {
      BigInteger n = new BigInteger(in.next());
      BigInteger k = new BigInteger(in.next());
      int lv = log2(k);
      if (k.compareTo(ONE) == 0) {
        printResult(n, t, out);
        continue;
      }
      BigInteger nAtLv = ONE.shiftLeft(lv);
      BigInteger nAtNextLv = ONE.shiftLeft(lv + 1);
      //out.printf("nAtLv = %s, nAtNextLv = %s\n", nAtLv, nAtNextLv);
      BigInteger[] divs = n.subtract(nAtLv).add(ONE).divideAndRemainder(nAtLv);
      //out.printf("div = %s, rem = %s\n", divs[0], divs[1]);
      BigInteger low = divs[0];
      BigInteger high = divs[0];
      if (divs[1].compareTo(ZERO) != 0) {
        high = low.add(ONE);
      }
      BigInteger nlow = nAtNextLv.subtract(ONE).subtract(k);
      BigInteger nhigh = nAtLv.subtract(nlow);
      BigInteger val = high;
      if ((nhigh.multiply(high)).add(nlow.multiply(low)).add(nAtLv).subtract(ONE).compareTo(n) > 0) {
        val = low;
      }
      //out.printf("low = %s, high = %s, nlow = %s, nhigh = %s, val = %s\n", low.toString(), high.toString(), nlow.toString(), nhigh.toString(), val.toString());
      printResult(val, t, out);
    }
  }

  private int log2(BigInteger x) {
    BigInteger base = new BigInteger("1");
    int count = 0;
    while (true) {
      base = base.shiftLeft(1);
      if (base.compareTo(x) > 0) {
        break;
      }
      count++;
    }
    return count;
  }

  private void printResult(BigInteger val, int test, PrintWriter out) {
    BigInteger low = val.subtract(BigInteger.ONE).divide(new BigInteger("2"));
    BigInteger high = val.divide(new BigInteger("2"));
    out.printf("Case #%d: %s %s\n", test, high.toString(), low.toString());
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
