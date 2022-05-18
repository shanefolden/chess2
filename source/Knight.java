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
}
