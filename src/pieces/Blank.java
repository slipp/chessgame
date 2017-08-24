package pieces;

public class Blank extends Piece {
    private Blank(Position position) {
        super(Color.NOCOLOR, Type.NO_PIECE, position);
    }
    
    public static Blank create(Position position) {
        return new Blank(position);
    }
}
