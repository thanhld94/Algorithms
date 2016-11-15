import java.io.PrintWriter;
import java.util.*;

public class TaskD {
  public static void main(String[] args) {
    TaskD tD = new TaskD();
    PrintWriter pw = new PrintWriter(System.out);
    tD.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
    int n = input.nextInt();
    int kingRow = input.nextInt();
    int kingCol = input.nextInt();
    int kingDia1 = kingRow - kingCol;
    int kingDia2 = kingRow + kingCol;
    
    // same row
    int rowLeft = Integer.MAX_VALUE;
    char pieceLeft = '$';
    int rowRight = Integer.MAX_VALUE;
    char pieceRight = '$';

    // same column
    int colTop = Integer.MAX_VALUE;
    char pieceTop = '$';
    int colBot = Integer.MAX_VALUE;
    char pieceBot = '$';

    // same diagonal 1
    int dia1Top = Integer.MAX_VALUE;
    char dia1TopPiece = '$';
    int dia1Bot = Integer.MAX_VALUE;
    char dia1BotPiece = '$';

    // same diagonal 2
    int dia2Top = Integer.MAX_VALUE;
    char dia2TopPiece = '$';
    int dia2Bot = Integer.MAX_VALUE;
    char dia2BotPiece = '$';

    for (int i = 0; i < n; i++) {
      char piece = input.next().charAt(0);
      int row = input.nextInt();
      int col = input.nextInt();
      int diagonalI = row - col;
      int diagonalII = row + col;
      int distance = Math.max(Math.abs(kingRow - row), Math.abs(kingCol - col));
      // same row
      if (row == kingRow && col < kingCol) { // same row as the king, on the left of the king
        if (distance < rowLeft) {
          pieceLeft = piece;
          rowLeft = distance;
        }
      }
      if (row == kingRow && col > kingCol) { // same row as the king, on the right of the king
        if (distance < rowRight) {
          pieceRight = piece;
          rowRight = distance;
        }
      }

      // same col
      if (col == kingCol && row < kingRow) { // same col, above
        if (distance < colTop) {
          pieceTop = piece;
          colTop = distance;
        }
      }
      if (col == kingCol && row > kingRow) { // same col, below
        if (distance < colBot) {
          pieceBot = piece;
          colBot = distance;
        }
      }

      // same diagonal I
      if (kingDia1 == diagonalI && col > kingCol) { // same dia1, above
        if (distance < dia1Top) {
          dia1TopPiece = piece;
          dia1Top = distance;
        }
      }
      if (kingDia1 == diagonalI && col < kingCol) { // same dia1, below
        if (distance < dia1Bot) {
          dia1BotPiece = piece;
          dia1Bot = distance;
        }
      }

      // same diagonal II
      if (kingDia2 == diagonalII && col < kingCol) { // same dia2, above
        if (distance < dia2Top) {
          dia2TopPiece = piece;
          dia2Top = distance;
        }
      }
      if (kingDia2 == diagonalII && col > kingCol) { // same dia2, below
        if (distance < dia2Bot) {
          dia2BotPiece = piece;
          dia2Bot = distance;
        }
      }
    }
    if (pieceLeft == 'R' || pieceLeft == 'Q' || pieceRight == 'R' || pieceRight == 'Q') {
      output.println("YES");
      return;
    }

    if (pieceTop == 'R' || pieceTop == 'Q' || pieceBot == 'R' || pieceBot == 'Q') {
      output.println("YES");
      return;
    }

    if (dia1TopPiece == 'B' || dia1TopPiece == 'Q' || dia2TopPiece == 'B' || dia2TopPiece == 'Q') {
      output.println("YES");
      return;
    }

    if (dia1BotPiece == 'B' || dia1BotPiece == 'Q' || dia2BotPiece == 'B' || dia2BotPiece == 'Q') {
      output.println("YES");
      return;
    }
    output.println("NO");
  }
}
