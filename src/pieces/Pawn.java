package pieces;

import java.util.List;

import pieces.Position.Degree;

public class Pawn extends Piece {
    private static final int WHITE_STARTING_INDEX = 1;
    private static final int BLACK_STARTING_INDEX = 6;

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
    
    boolean isStartingPosition() {
        int y = getPosition().getY();
        
        if (isWhite()) {
            return y == WHITE_STARTING_INDEX;
        }
        
        return y == BLACK_STARTING_INDEX;
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        List<Direction> directions = isWhite() ? Direction.whitePawnDirection() : Direction.blackPawnDirection();
        Direction direction = direction(target);
        if (!directions.contains(direction)) {
            throw new InvalidMovePositionException(target + " 위치는 이동할 수 없는 위치입니다.");
        }
        
        Degree degree = degree(target);
        if (!isStartingPosition() && degree.isOverOneYDegree()) {
            throw new InvalidMovePositionException(target + " 위치는 이동할 수 없는 위치입니다.");
        }
        
        if (isStartingPosition() && !degree.isUnderThreeYDegree()) {
            throw new InvalidMovePositionException(target + " 위치는 이동할 수 없는 위치입니다.");
        }
        
        return direction;
    }
}
