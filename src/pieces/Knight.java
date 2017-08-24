package pieces;

import java.util.List;

public class Knight extends Piece {
    private Knight(Color color, Position position) {
        super(color, Type.KNIGHT, position);
    }
    
    public static Knight createWhite(Position position) {
        return new Knight(Color.WHITE, position);
    }
    
    public static Knight createBlack(Position position) {
        return new Knight(Color.BLACK, position);
    }

    @Override
    public void verifyMovePosition(Position target) {
        List<Direction> directions = Direction.knightDirection();
        Direction direction = getPosition().direction(target);
        if (!directions.contains(direction)) {
            throw new InvalidMovePositionException(target + " 위치는 이동할 수 없는 위치입니다.");
        } 
    }
}
