import java.util.ArrayList;
import java.util.HashMap;

public class CommonInArrays {

  public static void main(String[] args) {
    int[] a = {5, 4, 1, -2, 3};
    int[] b = {1, 2, 4, 1, 0, -1, 1};
    for (Integer element : commonElements(a,b)) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static ArrayList<Integer> commonElements(int[] a, int[] b) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    for (int element : a) {
      if (!map.containsKey(element)) {
        map.put(element, 1);
      } else {
        map.put(element, map.get(element) + 1);
      }
    }
    
    for (int element : b) {
      Integer value = map.get(element);
      if (value != null && value > 0) {
        result.add(element);
        map.put(element, value - 1);
      }
    }
    return result;
  }
}
