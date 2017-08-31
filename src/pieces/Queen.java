package pieces;

public class Queen extends Piece {
    private Queen(Color color, Position position) {
        super(color, Type.QUEEN, position, Direction.everyDirection());
    }
    
    public static Queen createWhite(Position position) {
        return new Queen(Color.WHITE, position);
    }
    
    public static Queen createBlack(Position position) {
        return new Queen(Color.BLACK, position);
    }

    @Override
    protected String getWhiteSymbol() {
        return "&#9813;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9819;";
    }
}
