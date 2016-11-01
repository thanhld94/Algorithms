import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class TaskC{
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    Exam[] exams = new Exam[n];
    for (int i = 0; i < n; i++) {
      int a = input.nextInt();
      int b = input.nextInt();
      exams[i] = new Exam(a,b);
    }
    Arrays.sort(exams);
    int previous = exams[0].timeB;
    for (int i = 1; i < n; i++) {
      int current = exams[i].timeB;
      if (current < previous) {
        current = exams[i].timeA;
      }
      previous = current;
    }
    output.println(previous);
  }

  private class Exam implements Comparable<Exam> {
    int timeA;
    int timeB;

    private Exam(int a, int b) {
      timeA = a;
      timeB = b;
    }

    @Override public int compareTo(Exam other) {
      if (this.timeA == other.timeA) {
        return this.timeB - other.timeB;
      }
      return this.timeA - other.timeA;
    }
  }
}
