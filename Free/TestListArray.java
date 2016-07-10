import java.util.ArrayList;

public class TestListArray {
    public static void main(String[] args) {
        ArrayList <int[]> res = new ArrayList<int[]>();
        int[] a = {1,2,3,4};
        res.add(a.clone());
        a[2] = 10;
        res.add(a.clone());
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).length; j++)
                System.out.print(res.get(i)[j]);
            System.out.println();
        }
    }
}
