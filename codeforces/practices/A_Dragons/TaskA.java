import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TaskA{
  public static void main(String[] args) {
    TaskA tA = new TaskA();
    PrintWriter pw = new PrintWriter(System.out);
    tA.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int s = input.nextInt();
  	int n = input.nextInt();
  	Dragon[] dragons = new Dragon[n];
  	for (int i = 0; i < n; i++) {
  		int strength = input.nextInt();
  		int bonus = input.nextInt();
  		dragons[i] = new Dragon(strength, bonus);
  	}

  	Arrays.sort(dragons);
  	for (Dragon dragon : dragons) {
  		if (s <= dragon.strength) {
  			output.println("NO");
  			return;
  		}
  		s += dragon.bonus;
  	}
  	output.println("YES");
  }

  private class Dragon implements Comparable<Dragon>{
  	private int strength;
  	private int bonus;

  	private Dragon(int str, int bns) {
  		strength = str;
  		bonus = bns;
  	}

  	@Override public int compareTo(Dragon other) {
  		return strength - other.strength;
  	}
  }
}
