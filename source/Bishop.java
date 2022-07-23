import java.util.ArrayList;

public class Bishop extends Piece {

  public Bishop(int x, int y, boolean isWhite) {
    super(x, y, isWhite);
  }

  @Override
  public String toString() {
    return "Bishop " + super.toString();
  }

  @Override
  public String getTag() {
    if (color == Clr.WHITE) {
      return "WB";
    } else {
      return "BB";
    }
  }

  String private Boolean isDifferentColor(String piece){
    if

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
    validMoves = bishopMoves(pieceX, pieceY, boardPosition, validMoves);
    return validMoves;
  }

  public ArrayList<int[]> bishopMoves(
    int pieceX,
    int pieceY,
    String[][] boardPosition,
    ArrayList<int[]> validMoves
  ) {
    // Check all 4 directions
    for (int i = 1; i < 8; i++) {
      // Check up-right
      if (pieceX + i < 8 && pieceY + i < 8) {
        if (boardPosition[pieceX + i][pieceY + i] == "XX") {
          validMoves.add(new int[] { pieceX + i, pieceY + i });
        } else if (isDifferentColor(boardPosition[pieceX + i][pieceY + i])) {
          validMoves.add(new int[] { pieceX + i, pieceY + i });
        } 
      }
      else {break;}
      // Check up-left
      if (pieceX - i >= 0 && pieceY + i < 8) {
        if (boardPosition[pieceX - i][pieceY + i] == "XX") {
          validMoves.add(new int[] { pieceX - i, pieceY + i });
        } else if  (isDifferentColor(boardPosition[pieceX - i][pieceY + i])) {
          validMoves.add(new int[] { pieceX - i, pieceY + i });
        } 
        }
        else{ break;}
      // Check down-right
      if (pieceX + i < 8 && pieceY - i >= 0) {
        if (boardPosition[pieceX + i][pieceY - i] == "XX") {
          validMoves.add(new int[] { pieceX + i, pieceY - i });
        } 
        else if (isDifferentColor(boardPosition[pieceX + i][pieceY - i])) {
          validMoves.add(new int[] { pieceX + i, pieceY - i });
        }
      }
      else{break;}
      // Check down-left
      if (pieceX - i >= 0 && pieceY - i >= 0) {
        if (boardPosition[pieceX - i][pieceY - i] == "XX") {
          validMoves.add(new int[] { pieceX - i, pieceY - i });
        } else if (isDifferentColor(boardPosition[pieceX - i][pieceY - i])) {
          validMoves.add(new int[] { pieceX - i, pieceY - i });
        }
      }
      else {break;}
      return validMoves;
    }
    
  }
}
