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
    output.println("import java.io.PrintWriter;");
    output.println("import java.util.*;\n");
    output.println("public class Task" + task + " {");
    
    //main method
    output.println("  public static void main(String[] args) {");
    output.println("    Task" + task + " t" + task + " = new Task" + task + "();");
    output.println("    PrintWriter pw = new PrintWriter(System.out);");
    output.println("    t" + task + ".solve(new Scanner(System.in), pw);");
    output.println("    pw.close();");
    output.println("  }\n");
    
    //solve method
    output.println("  public void solve(Scanner input, PrintWriter output) {");
    output.println("  }");

    //end class
    output.println("}");
    output.close();
  }
}
