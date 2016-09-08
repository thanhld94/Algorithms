import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB{
  private static final long BOUND = 1000000000000000000L;
  
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    //int n = input.nextInt();
    int n = 498;
    long[][] matrix = new long[n][n];
    int targetRow = 0;
    int targetCol = 0;

    if (n == 1) {
      output.println(1);
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        //matrix[i][j] = input.nextLong();
        matrix[i][j] = 536870913L;
        if (matrix[i][j] == 0) {
          targetRow = i;
          targetCol = j;
        }
      }
    }
    matrix[0][0] = 0;

    long[] sumRow = getRowSum(matrix);
    long[] sumCol = getColSum(matrix);
    
    long targetSum = getTargetSum(sumRow, sumCol, targetRow, targetCol);
    if (targetSum == -1) {
      output.println(-1);
      return;
    }

    if (sumRow[targetRow] != sumCol[targetCol]) {
      output.println(-1);
      return;
    }

    matrix[targetRow][targetCol] = targetSum - sumRow[targetRow];
    if (matrix[targetRow][targetCol] <= 0 || matrix[targetRow][targetCol] > BOUND) {
      output.println(-1);
      return;
    }
    long diagonal1 = 0L;
    long diagonal2 = 0L;
    for (int i = 0; i < n; i++) {
      diagonal1 += matrix[i][i];
      diagonal2 += matrix[i][n - i - 1];
    }
    if (diagonal1 == diagonal2) {
      output.println(matrix[targetRow][targetCol]);
    } else {
      output.println(-1);
    }
  }

  private long[] getRowSum(long[][] matrix) {
    int n = matrix.length;
    long[] result = new long[n];
    for (int row = 0; row < n; row++) {
      for (long cell : matrix[row]) {
        result[row] += cell;
      }
    }
    return result;
  }

  private long[] getColSum(long[][] matrix) {
    int n = matrix.length;
    long[] result = new long[n];
    for (int col = 0; col < n; col++) {
      for (int row = 0; row < n; row++) {
        result[col] += matrix[row][col];
      }
    }
    return result;
  }

  private long getTargetSum(long[] rows, long[] cols, int x, int y) {
    long result = 0L;
    for (int row = 0; row < rows.length; row++) {
      if (row != x) {
        if (result == 0) {
          result = rows[row];
        } else {
          if (result != rows[row]) {
            return -1;
          }
        }
      }
    }

    for (int col = 0; col < cols.length; col++) {
      if (col != y && result != cols[col]) {
        return -1;
      }
    }
    return result;
  }
}
