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
}
