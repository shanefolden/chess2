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
}
