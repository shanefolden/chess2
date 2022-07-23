import java.util.ArrayList;

public class Rook extends Piece {

  public Rook(int x, int y, boolean isWhite) {
    super(x, y, isWhite);
  }

  @Override
  public String toString() {
    return "Rook " + super.toString();
  }

  @Override
  public String getTag() {
    if (color == Clr.WHITE) {
      return "WR";
    } else {
      return "BR";
    }
  }

  private Boolean isDifferentColor(String piece) {
    char piece_color = piece.charAt(0);
    if (color == Clr.WHITE) {
      if (piece_color == 'W') {
        return false;
      }
    } else if (color == Clr.BLACK) {
      if (piece_color == 'B') {
        return false;
      }
    }
    return true;
  }

  @Override
  public ArrayList<int[]> getMoves() {
    ArrayList<int[]> validMoves = new ArrayList<int[]>();
    GameManager game = new GameManager();
    var boardPosition = game.getBoardPosition();
    int[] piecePosition = getPosition();
    int pieceX = piecePosition[0];
    int pieceY = piecePosition[1];

    // Check all 4 directions
    validMoves = rookMoves(pieceX, pieceY, boardPosition, validMoves);
    return validMoves;
  }

  public ArrayList<int[]> rookMoves(
    int pieceX,
    int pieceY,
    String[][] boardPosition,
    ArrayList<int[]> validMoves
  ) {
    // Check all 4 directions
    for (int i = 1; i < 8; i++) {
      // Check up
      if (pieceY + i < 8) {
        if (boardPosition[pieceX][pieceY + i] == "XX") {
          validMoves.add(new int[] { pieceX, pieceY + i });
        } else if (isDifferentColor(boardPosition[pieceX][pieceY + i])) {
          validMoves.add(new int[] { pieceX, pieceY + i });
        }
      }
      // Check left
      if (pieceX - i >= 0) {
        if (boardPosition[pieceX - i][pieceY] == "XX") {
          validMoves.add(new int[] { pieceX - i, pieceY });
        } else if (isDifferentColor(boardPosition[pieceX - i][pieceY])) {
          validMoves.add(new int[] { pieceX - i, pieceY });
        }
      }
      // Check right
      if (pieceX + i < 8) {
        if (boardPosition[pieceX + i][pieceY] == "XX") {
          validMoves.add(new int[] { pieceX + i, pieceY });
        } else if (isDifferentColor(boardPosition[pieceX + i][pieceY])) {
          validMoves.add(new int[] { pieceX + i, pieceY });
        }
      }
      // Check down
      if (pieceY - i >= 0) {
        if (boardPosition[pieceX][pieceY - i] == "XX") {
          validMoves.add(new int[] { pieceX, pieceY - i });
        } else if (isDifferentColor(boardPosition[pieceX][pieceY - i])) {
          validMoves.add(new int[] { pieceX, pieceY - i });
        }
      }
    }
    return validMoves;
  }
}
