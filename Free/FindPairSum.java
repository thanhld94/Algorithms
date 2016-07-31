import java.util.HashMap;

public class FindPairSum {

  public static void main(String[] args) {
    int[] arr = new int[args.length - 1];
    int target = Integer.parseInt(args[args.length - 1]);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    FindPairSum fps = new FindPairSum();
    Pair result = fps.findPairSum(arr,target);
    System.out.println(result.first + " " + result.second);
  }

  public Pair findPairSum(int[] arr, int target) {
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    for (int element : arr) {
      if (map.containsKey(target - element)) {
        return new Pair(element, target - element);
      }
      if (!map.containsKey(element)) {
        map.put(element, true);
      }
    }
    return null;
  }

  private class Pair {
    private int first;
    private int second;
    
    private Pair(int f, int s) {
      first = f;
      second = s;
    }
  }
}
