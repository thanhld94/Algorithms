import java.util.*;
import java.io.*;

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
    int nominator = Integer.parseInt(st.nextToken());
    int denominator = Integer.parseInt(st.nextToken());
    while (nominator != 1 ||  denominator != 1) {
      String result = getResult(new Fraction(nominator, denominator));
      output.println(result);
      st = new StringTokenizer(input.readLine());
      nominator = Integer.parseInt(st.nextToken());
      denominator = Integer.parseInt(st.nextToken());
    }
  }

  private String getResult(Fraction target) {
    Node current = new Node(1, 1);
    current.left = new Node(0, 1);
    current.right = new Node(1, 0);
    
    StringBuilder sb = new StringBuilder();
    while (target.compareTo(current.value) != 0) {
      if (target.compareTo(current.value) > 0) { // go right
        sb.append("R");
        current = current.addRight();
      } else { // go left
        sb.append("L");
        current = current.addLeft();
      }
    }
    return sb.toString();
  }

  private class Fraction implements Comparable<Fraction> {
    private int nominator;
    private int denominator;

    private Fraction(int nominator, int denominator) {
      this.nominator = nominator;
      this.denominator = denominator;
    }
  
    private Fraction add(Fraction other) {
      return (new Fraction(nominator + other.nominator, denominator + other.denominator));
    }

    @Override public int compareTo(Fraction other) {
      return nominator * other.denominator - other.nominator * denominator;
    }
  }

  private class Node {
    private Fraction value;
    private Node left;
    private Node right;

    private Node(int nominator, int denominator) {
      value = new Fraction(nominator, denominator);
      left = right = null;
    }

    private Node(Fraction value) {
      this.value = value;
      left = right = null;
    }

    private Node addLeft() {
      Node next = new Node(value.add(left.value));
      next.left = left;
      next.right = this;
      left.right = next;
      this.left = next;
      return next;
    }

    private Node addRight() {
      Node next = new Node(value.add(right.value));
      next.right = right;
      next.left = this;
      right.left = next;
      this.right = next;
      return next;
    }
  }
}
