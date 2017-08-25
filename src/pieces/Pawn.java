package pieces;

public class Pawn extends Piece {
    private Pawn(Color color, Position position) {
        super(color, Type.PAWN, position);
    }
    
    public static Pawn create(Color color, Position position) {
        return new Pawn(color, position);
    }
    
    public static Pawn createWhite(Position position) {
        return new Pawn(Color.WHITE, position);
    }
    
    public static Pawn createBlack(Position position) {
        return new Pawn(Color.BLACK, position);
    }

    @Override
    public Direction verifyMovePosition(Position target) {
        return null;
    }
}
