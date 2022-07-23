import java.lang.Math;
import java.util.ArrayList;

public class King extends Piece {

  public King(int x, int y, boolean isWhite) {
    super(x, y, isWhite);
  }

  @Override
  public String toString() {
    return "King " + super.toString();
  }

  @Override
  public String getTag() {
    if (color == Clr.WHITE) {
      return "WK";
    } else {
      return "BK";
    }
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
    validMoves = kingMoves(pieceX, pieceY, boardPosition, validMoves);
    return validMoves;
  }

  public ArrayList<int[]> kingMoves(
    int pieceX,
    int pieceY,
    String[][] boardPosition,
    ArrayList<int[]> validMoves
  ) {
    Queen fakeKing = new Queen(pieceX, pieceY, color == Clr.WHITE);
    validMoves = fakeKing.getMoves();

    for (int[] move : validMoves) {
      if (Math.abs(move[0] - pieceX) > 1 || Math.abs(move[1] - pieceY) > 1) {
        validMoves.remove(move);
      }
    }
    return validMoves;
  }
}
