package pieces;

public class Blank extends Piece {
    private Blank(Position position) {
        super(Color.NOCOLOR, Type.NO_PIECE, position);
    }
    
    public static Blank create(Position position) {
        return new Blank(position);
    }

    @Override
    public void verifyMovePosition(Position target) {
        throw new InvalidMovePositionException("말이 아니라 이동할 수 없습니다.");
    }
}
