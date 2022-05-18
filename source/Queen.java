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
}
