public class PalindromeTree {
  private TreeNode[] tree;
  private String s;
  private int suffix;

  public static void main(String[] args) {
    String text = args[0];
    PalindromeTree pt = new PalindromeTree(text);
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
      if (pt.add(i)) {
        count += pt.tree[pt.suffix].count;
      }
    }
    System.out.println(count);
  }

  public PalindromeTree(String s) {
    this.s = s;
    suffix = 1; // initial suffix is the empty string the second root
    tree = new TreeNode[s.length() + 2];
    tree[0] = new TreeNode(-1, 0);
    tree[1] = new TreeNode(0, 0);
  }

  public boolean add(int pos) {
    int current = suffix;
    while (true) {
      int currentLength = tree[current].len;
      if (pos - 1 - currentLength >= 0 && s.charAt(pos) == s.charAt(pos - 1 - currentLength)) {
        break;
      }
      current = tree[current].suffixLink;
    }

    int letter = s.charAt(pos) - 'a';
    if (tree[current].next[letter] != 0) { // xAx already exists 
      suffix = tree[current].next[letter];
      return false;
    }

    suffix++;
    tree[suffix] = new TreeNode(tree[current].len + 2, 0);
    tree[current].next[letter] = suffix;

    if (tree[suffix].len == 1) { // new single character -> link to empty
      tree[suffix].suffixLink = 1;
      tree[suffix].count = 1;
      return true;
    }

    while (true) {
      current = tree[current].suffixLink;
      int currentLength = tree[current].len;
      if (pos - 1 - currentLength >= 0 && s.charAt(pos) == s.charAt(pos - 1 - currentLength)) {
        tree[suffix].suffixLink = tree[current].next[letter];
        break;
      }
    }
    tree[suffix].count = 1 + tree[tree[suffix].suffixLink].count;
    return true;
  }

  private class TreeNode {
    private int len;
    private int suffixLink;
    private int[] next;
    private int count;

    private TreeNode(int len, int suffixLink) {
      this.len = len;
      this.count = 0;
      this.suffixLink = suffixLink;
      next = new int[26]; // Assume only lowercase characters
    }
  }
}
