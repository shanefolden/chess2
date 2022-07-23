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
  //@Override
  //public ArrayList<int[]> getMoves() {}
}
