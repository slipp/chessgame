package pieces;

public class Bishop extends Piece {
    Bishop(Color color, Position position) {
        super(color, Type.BISHOP, position, Direction.diagonalDirection());
    }
    
    public static Bishop createWhite(Position position) {
        return new Bishop(Color.WHITE, position);
    }
    
    public static Bishop createBlack(Position position) {
        return new Bishop(Color.BLACK, position);
    }

    @Override
    protected String getWhiteSymbol() {
        return "&#9815;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9821;";
    }
}
