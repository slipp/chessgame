package pieces;

import java.util.Arrays;
import java.util.List;

public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1),
	
	NNE(1, 2),
	NNW(-1, 2),
	SSE(1, -2),
	SSW(-1, -2),
	EEN(2, 1),
	EES(2, -1),
	WWN(-2, 1),
	WWS(-2, -1);

    private int xDegree;
    private int yDegree;

    private Direction(int xDegree, int yDegree) {
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public int getXDegree() {
        return xDegree;
    }

    public int getYDegree() {
        return yDegree;
    }
    
    public boolean isOverOneXDegree() {
        return xDegree > 1;
    }
    
    public boolean isOverOneYDegree() {
        return yDegree > 1;
    }
    
    private static int convertToOne(int number) {
        if (number == 0) {
            return 0;
        }
        
        if (number > 0) {
            return 1;
        }
        
        return -1;
    }
    
    public static Direction valueOf(int x, int y) throws InvalidMovePositionException {
        Direction[] directions = values();
        for (Direction direction : directions) {
            if (x == direction.xDegree && y == direction.yDegree) {
                return direction;
            }
        }
        
        throw new InvalidMovePositionException("유효하지 않은 위치입니다.");
    }
    
    public static Direction valueOfPawn(int x, int y) throws InvalidMovePositionException {
        return valueOf(convertToOne(x), convertToOne(y));
    }
    
    public static Direction valueOfDiagonal(int x, int y) throws InvalidMovePositionException {
        int remainder = x % y;
        
        if (remainder != 0) {
            throw new InvalidMovePositionException("유효하지 않은 위치입니다.");
        }
        
        return valueOf(convertToOne(x), convertToOne(y));
    }
    
    public static Direction valueOfLinear(int x, int y) throws InvalidMovePositionException {
        if (x != 0 && y != 0) {
            throw new InvalidMovePositionException("유효하지 않은 위치입니다.");
        }
        
        return valueOf(convertToOne(x), convertToOne(y));
    }
    
    public static Direction valueOfEvery(int x, int y) throws InvalidMovePositionException {
        try {
            return valueOfLinear(x, y);
        } catch (InvalidMovePositionException e) {
            return valueOfDiagonal(x, y);
        }
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }
    
    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
    }
    
    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }
}
