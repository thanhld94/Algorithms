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
    output.println("  public static void main(String[] args) throws IOException {");
    output.println("    Task" + task + " t" + task + " = new Task" + task + "();");
    output.println("    PrintWriter out = new PrintWriter(System.out);");
    output.println("    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));");
    output.println("    t" + task + ".solve(in, out);");
    output.println("    out.close();");
    output.println("  }\n");
    
    //solve method
    output.println("  public void solve(BufferedReader in, PrintWriter out) throws IOException {");
    output.println("  }");

    //end class
    output.println("}");
    output.close();
  }
}
