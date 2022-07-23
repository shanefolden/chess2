import java.util.ArrayList;

public class Queen extends Piece {

  public Queen(int x, int y, boolean isWhite) {
    super(x, y, isWhite);
  }

  @Override
  public String toString() {
    return "Queen " + super.toString();
  }

  @Override
  public String getTag() {
    if (color == Clr.WHITE) {
      return "WQ";
    } else {
      return "BQ";
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
    validMoves = queenMoves(pieceX, pieceY, boardPosition, validMoves);
    return validMoves;
  }

  public ArrayList<int[]> queenMoves(
    int pieceX,
    int pieceY,
    String[][] boardPosition,
    ArrayList<int[]> validMoves
  ) {
    Bishop fakeBishop = new Bishop(pieceX, pieceY, color == Clr.WHITE);
    Rook fakeRook = new Rook(pieceX, pieceY, color == Clr.WHITE);
    validMoves = fakeBishop.getMoves();
    validMoves.addAll(fakeRook.getMoves());
    return validMoves;
  }
}
