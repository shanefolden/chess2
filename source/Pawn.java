public class Pawn extends Piece {

    public Pawn(int x, int y, boolean isWhite){
        super(x,y,isWhite);
    }

    @Override public String toString(){
        return "Pawn " + super.toString();
    }

}
