import java.util.ArrayList;

public class Pawn extends Piece {

  public Pawn(int x, int y, boolean isWhite) {
    super(x, y, isWhite);
  }

  @Override
  public String toString() {
    return "Pawn " + super.toString();
  }

  @Override
  public String getTag() {
    if (color == Clr.WHITE) {
      return "WP";
    } else {
      return "BP";
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
    validMoves = pawnMoves(pieceX, pieceY, boardPosition, validMoves);
    return validMoves;
  }

  public ArrayList<int[]> pawnMoves(
    int pieceX,
    int pieceY,
    String[][] boardPosition,
    ArrayList<int[]> validMoves
  ) {
    String newPos = boardPosition[pieceX][pieceY + 1];
    if (newPos == "XX" || isDifferentColor(newPos)) {
      validMoves.add(new int[] { pieceX, pieceY + 1 });
    }
    if (pieceY == 2) {
      String startingPos = boardPosition[pieceX][pieceY + 2];
      if (startingPos == "XX" || isDifferentColor(startingPos)) {
        validMoves.add(new int[] { pieceX, pieceY + 2 });
      }
    }
    return validMoves;
  }
}
