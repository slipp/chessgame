package pieces;

import java.util.List;

public class King extends Piece {
    private King(Color color, Position position) {
        super(color, Type.KING, position);
    }
    
    public static King createWhite(Position position) {
        return new King(Color.WHITE, position);
    }
    
    public static King createBlack(Position position) {
        return new King(Color.BLACK, position);
    }

    @Override
    public void verifyMovePosition(Position target) {
        System.out.println("Target Position : " + target);
        List<Direction> directions = Direction.everyDirection();
        Direction direction = getPosition().direction(target);
        if (!directions.contains(direction)) {
            throw new InvalidMovePositionException(target + " 위치는 이동할 수 없는 위치입니다.");
        }
    }
}
