package pieces;

public class Rook extends Piece {
    private Rook(Color color, Position position) {
        super(color, Type.ROOK, position, Direction.linearDirection());
    }
    
    public static Rook createWhite(Position position) {
        return new Rook(Color.WHITE, position);
    }
    
    public static Rook createBlack(Position position) {
        return new Rook(Color.BLACK, position);
    }

    @Override
    protected String getWhiteSymbol() {
        return "&#9814;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9820;";
    }
}
