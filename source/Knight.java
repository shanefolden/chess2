import java.lang.Math;
import java.util.ArrayList;

public class Knight extends Piece {

  public Knight(int x, int y, boolean isWhite) {
    super(x, y, isWhite);
  }

  @Override
  public String toString() {
    return "Knight " + super.toString();
  }

  @Override
  public String getTag() {
    if (color == Clr.WHITE) {
      return "WN";
    } else {
      return "BN";
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
    validMoves = knightMoves(pieceX, pieceY, boardPosition, validMoves);
    return validMoves;
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

  public ArrayList<int[]> knightHelper(
    ArrayList<int[]> moves,
    String[][] boardPosition
  ) {
    for (int[] move : moves) {
      if (
        !(
          boardPosition[move[0]][move[1]] == "XX" ||
          isDifferentColor(boardPosition[move[0]][move[1]])
        )
      ) {
        moves.remove(move);
      }
    }
    return moves;
  }

  public ArrayList<int[]> knightMoves(
    int pieceX,
    int pieceY,
    String[][] boardPosition,
    ArrayList<int[]> validMoves
  ) {
    if (pieceX + 2 < 8 && pieceX + 2 > 0) {
      if (pieceY + 1 < 8 && pieceY + 1 > 0) {
        validMoves.add(new int[] { pieceX + 2, pieceY + 1 });
      }
      if (pieceY - 1 < 8 && pieceY - 1 > 0) {
        validMoves.add(new int[] { pieceX + 2, pieceY - 1 });
      }
    }
    if (pieceX - 2 < 8 && pieceX - 2 > 0) {
      if (pieceY + 1 < 8 && pieceY + 1 > 0) {
        validMoves.add(new int[] { pieceX - 2, pieceY + 1 });
      }
      if (pieceY - 1 < 8 && pieceY - 1 > 0) {
        validMoves.add(new int[] { pieceX - 2, pieceY - 1 });
      }
    }
    if (pieceX + 1 < 8 && pieceX + 1 > 0) {
      if (pieceY + 2 < 8 && pieceY + 2 > 0) {
        validMoves.add(new int[] { pieceX + 1, pieceY + 2 });
      }
      if (pieceY - 2 < 8 && pieceY - 2 > 0) {
        validMoves.add(new int[] { pieceX + 1, pieceY - 2 });
      }
    }
    if (pieceX - 1 < 8 && pieceX - 1 > 0) {
      if (pieceY + 2 < 8 && pieceY + 2 > 0) {
        validMoves.add(new int[] { pieceX - 1, pieceY + 2 });
      }
      if (pieceY - 2 < 8 && pieceY - 2 > 0) {
        validMoves.add(new int[] { pieceX - 1, pieceY - 2 });
      }
    }

    return knightHelper(validMoves, boardPosition);
  }
}
