public class Merge {
  
  public static void main(String[] args) {
    int[] a = {1,2,2,3,3,3,0,0,0,0,0};
    int[] b = {1,1,1,9,9};
    merge(a,6,b,5);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
  
  public static void merge(int[] a, int n, int[] b, int m) {
    int first = n;
    int last = n-1;
    for (int i = n; i < n + m; i++) {
      a[i] = Integer.MAX_VALUE;
    }
    int idx = 0;
    for (int i = 0; i < n; i++) {
      int peek = (first <= last) ? a[first] : Integer.MAX_VALUE;
      if (a[i] > peek || (idx < m && a[i] > b[idx])) {
        if (last + 1 < n + m) {
          a[++last] = a[i];
        }
        if (idx >= m || peek < b[idx]) {
          a[i] = peek;
          a[first++] = Integer.MAX_VALUE;
        } else {
          a[i] = b[idx++]; 
        }
      }
    }
    for (int i = n; i < n + m; i++) {
      //for (int x : a) System.out.print(x + " "); System.out.println();
      //for (int x : b) System.out.print(x + " "); System.out.println();
      //System.out.println("first = " + first);
      //System.out.println("idx = " + idx + "\n");
      if (idx > m) {
        return;
      } else if (first >= n + m) {
        if (idx < m) {
          a[i] = b[idx++];
        }
      } else if (idx < m && first < n + m) { 
        if (b[idx] < a[first]) {
          a[i] = b[idx++];
        } else {
          a[i] = a[first];
          a[first++] = Integer.MAX_VALUE;
        }
      }
    }
  }
}
