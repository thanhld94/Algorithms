import java.util.*;

public class Arrfix {
  
  public int mindiff(int[] A, int[] B, int[] F) {
    int[] countF = new int[1001];

    for (int val : F) {
      countF[val]++;
    }

    int count = 0;
    boolean[] used = new boolean[A.length];
    for (int i = 0; i < A.length; i++) {
      if (A[i] != B[i]) {
        if (countF[B[i]] > 0) {
          countF[B[i]]--;
          used[i] = true;
        } else {
          count++;
        }
      }
    }

    for (int val = 1; val <= 1000; val++) {
      if (countF[val] == 0) continue;
      for (int i = 0; i < B.length; i++) {
        if (val == B[i] && !used[i]) {
          used[i] = true;
          countF[val]--;
          if (countF[val] == 0) {
            break;
          }
        }
      }
    }

    int rem = 0;
    for (int val : countF) {
      rem += val;
    }

    for (int i = 0; i < B.length; i++) {
      if (rem == 0) break;
      if (!used[i] && A[i] != B[i]) rem--;  
    } 
    return count += rem;
  }

}
