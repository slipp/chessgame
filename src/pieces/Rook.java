package pieces;

public class Rook extends Piece {
    private Rook(Color color, Position position) {
        super(color, Type.ROOK, position);
    }
    
    public static Rook createWhite(Position position) {
        return new Rook(Color.WHITE, position);
    }
    
    public static Rook createBlack(Position position) {
        return new Rook(Color.BLACK, position);
    }

    @Override
    public void verifyMovePosition(Position target) {
        
    }
}
