import java.util.Hashtable;

public class HashTest {
    public static void main(String[] args) {
        Hashtable <Integer, Integer> map = new Hashtable <Integer,Integer>();
        map.put(3,3);
        map.put(1,12);
        map.put(4,12);
        map.put(9,143);
        map.put(3, 4);
        map.put(2,1);
        System.out.println(map.containsKey(9));
        System.out.println(map);
    }
}
