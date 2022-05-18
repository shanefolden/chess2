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
}
