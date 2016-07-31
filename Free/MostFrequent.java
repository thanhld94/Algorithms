import java.util.HashMap;
import java.util.Map.Entry;

public class MostFrequent {
  public static void main(String[] args) {
    int[] arr = new int[args.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    MostFrequent mf = new MostFrequent();
    System.out.println("result = " + mf.mostFrequent(arr));
  }
  
  public int mostFrequent(int[] arr) {
    HashMap<Integer, Integer> map = getFrequency(arr); 
    int maxFrequency = 0;
    int result = (1 << 32) - 1;
    for(Entry<Integer, Integer> entry : map.entrySet()) {
      if (maxFrequency < entry.getValue()) {
        result = entry.getKey();
        maxFrequency = entry.getValue();
      }
    }
    return result;
  }

  private HashMap<Integer,Integer> getFrequency(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      Integer value = map.get(arr[i]);
      if (value == null) {
        map.put(arr[i], 1);
      } else {
        map.put(arr[i], value + 1);
      }
    }
    return map;
  }
}
