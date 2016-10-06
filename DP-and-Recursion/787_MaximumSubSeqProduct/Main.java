import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  
  public static void main(String[] args) {
    ArrayList<BigInteger> list = new ArrayList<BigInteger>();
    BigInteger el, end, pro, maxPro;
    end = new BigInteger("-999999");
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      el = sc.nextBigInteger();
      if(el.compareTo(end)!=0)list.add(el);
      else{
        maxPro = list.get(0);
        for(int i = 0; i < list.size(); i++){
          pro = BigInteger.ONE;
          for(int j = i; j < list.size(); j++){
            pro = pro.multiply(list.get(j));
            maxPro = maxPro.max(pro);
          }
        }
        System.out.println(maxPro);
        list.clear();
      }
    }
  }
}
