package templatemaker;

import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TemplateMaker {
  public static void main(String[] args) throws IOException, FileNotFoundException {
    // import
    String contest = args[0];
    String problemName = args[1];
    String task = args[2].toUpperCase();
    File outputfile = new File(contest + "/" + task + "_" + problemName + "/Task" + task + ".java");
    outputfile.getParentFile().mkdirs();
    outputfile.createNewFile();
    

    PrintWriter output = new PrintWriter(outputfile);
    //start class
    output.println("import java.io.*;");
    output.println("import java.util.*;\n");
    output.println("public class Task" + task + " {");
    
    //main method
    output.println("  public static void main(String[] args) {");
    output.println("    Task" + task + " t" + task + " = new Task" + task + "();");
    output.println("    BScanner in = new BScanner();");
    output.println("    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));");
    output.println("    t" + task + ".solve(in, out);");
    output.println("    out.close();");
    output.println("  }\n");
    
    //solve method
    output.println("  public void solve(BScanner in, PrintWriter out) {");
    output.println("  }\n");

    //Scanner class
    output.println("  private static class BScanner {");
    output.println("    private BufferedReader input;");
    output.println("    private StringTokenizer st;\n");
    output.println("    private BScanner() {");
    output.println("      input = new BufferedReader(new InputStreamReader(System.in));");
    output.println("    }\n");
    output.println("    private String next() {");
    output.println("      while (st == null || !st.hasMoreElements()) {");
    output.println("        try {");
    output.println("          st = new StringTokenizer(input.readLine());");
    output.println("        } catch (IOException e) {");
    output.println("          System.err.println(\"No more token\");");
    output.println("          e.printStackTrace();");
    output.println("        }");
    output.println("      }");
    output.println("      return st.nextToken();");
    output.println("    }\n");
    output.println("    private int nextInt() {");
    output.println("      return Integer.parseInt(next());");
    output.println("    }\n");
    output.println("    private long nextLong() {");
    output.println("      return Long.parseLong(next());");
    output.println("    }\n");
    output.println("    private double nextDouble() {");
    output.println("      return Double.parseDouble(next());");
    output.println("    }\n");
    output.println("    private String nextLine() {");
    output.println("      String line = \"\";");
    output.println("      try {");
    output.println("        line = input.readLine();");
    output.println("      } catch (Exception e) {");
    output.println("        System.err.println(\"No more lines\");");
    output.println("        e.printStackTrace();");
    output.println("      }");
    output.println("      return line;");
    output.println("    }");
    output.println("  }");

    //end class
    output.println("}");
    output.close();
  }
}
