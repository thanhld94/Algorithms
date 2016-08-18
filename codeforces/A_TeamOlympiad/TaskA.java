import java.io.PrintWriter;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	List<List<Integer>> subject = new ArrayList<List<Integer>>();
  	
  	for (int i = 0; i < 3; i++) {
  		subject.add(new ArrayList<Integer>());
  	}

  	for (int i = 1; i <= n; i++) {
  		int x = input.nextInt() - 1;
  		subject.get(x).add(i);
  	}

  	int min = n;
  	for (int i = 0; i < 3; i++) {
  		min = Math.min(min, subject.get(i).size());
  	}

  	output.println(min);
  	for (int i = 0; i < min; i++) {
  		for (int j = 0; j < 3; j++) {
  			output.print(subject.get(j).get(i) + " ");
  		}
  		output.println();
  	}
  }
}
