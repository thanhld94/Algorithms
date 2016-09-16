import java.util.*;
import java.io.*;

public class Gen {
  public static void main(String[] args) throws IOException {
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("input2.in")));
    int t = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    output.println(t);
    for (int i = 0; i < t; i++) {
      output.println(n);
      for (int j = 0; j < n; j++) {
        output.print("5000 ");
      }
      output.println();
    }
    output.close();
  }
}
