import java.util.Map;
import java.util.HashMap;

public class HashTest {
    public static void main(String[] args) {
        HashTest ht = new HashTest();
        ht.test();
    }

    public void test() {
        int[] arr = {1,4,2,3};
        int[] arr2 = {1,4,2,3};
        Map<int[],Boolean> obMap = new HashMap<int[], Boolean>();
        obMap.put(arr, true);
        if (obMap.containsKey(arr2)) {
          System.out.println(true);
        } else {
          System.out.println(false);
        }
    }

    private class SomeObject {
      private int[] arr;
      
      private SomeObject(int[] arr) {
        this.arr = arr.clone();
      }

      @Override public boolean equals(Object o) {
        if (!(o instanceof SomeObject)) {
          return false;
        }
        SomeObject other = (SomeObject) o;
        if (arr.length != other.arr.length) {
          return false;
        }
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] != other.arr[i]) {
            return false;
          }
        }
        return true;
      }
    }
}
