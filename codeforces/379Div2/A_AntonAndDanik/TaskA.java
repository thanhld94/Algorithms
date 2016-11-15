import java.io.PrintWriter;
import java.util.*;

public class TaskA {
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    String text = input.next();
    int countA = 0;
    for (int idx = 0; idx < n; idx++) {
      if (text.charAt(idx) == 'A') 
        countA++;
    }
    int countD = text.length() - countA;
    if (countA > countD) 
      output.println("Anton");
    else if (countA < countD) 
      output.println("Danik");
    else 
      output.println("Friendship");
  }
}
