import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class TaskC {
  public static void main(String[] args) {
    TaskC tC = new TaskC();
    PrintWriter pw = new PrintWriter(System.out);
    tC.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    TreeNode root = new TreeNode(null, "/");
    TreeNode current = root;
    for (int i = 0; i < n; i++) {
      String cmd = input.next();
      if (cmd.equals("pwd")) {
        output.println(current.absolutePath);
      } else {
        String path = input.next();
        String[] folders = getPath(path);
        if (isAbsolute(path)) {
          current = root;
        }
        for (String folder : folders) {
          TreeNode next = current.get(folder);
          current = next;
        }
      }
    }
  }

  private String[] getPath(String path) {
    if (!isAbsolute(path)) {
      return path.split("/");
    }
    return path.substring(1).split("/");
  }

  private boolean isAbsolute(String path) {
    return path.charAt(0) == '/';
  }

  private class TreeNode {
    private String absolutePath;
    private Map<String, TreeNode> adj;

    private TreeNode(TreeNode parent, String path) {
      absolutePath = path;
      adj = new HashMap<String, TreeNode>();
      adj.put("..", parent);
    }

    private TreeNode get(String folder) {
      if (adj.containsKey(folder)) {
        return adj.get(folder);
      }
      String path = absolutePath + folder + "/";
      TreeNode next = new TreeNode(this, path);
      adj.put(folder, next);
      return next;
    }
  }
}
