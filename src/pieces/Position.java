package pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Position {
    private static final String X_ALPHABET = "abcdefgh";
    public static final int ROW_SIZE = 8;
    public static final int COLUMN_SIZE = 8;
    
    private int x;
    private int y;
    private String charPosition;
    
    public Position(String position) {
        if (position.length() != 2) {
            throw new InvalidPositionException(position + "은 유효한 위치가 아닙니다.");
        }
        
        this.x = getX(position);
        this.y = getY(position);
        this.charPosition = position;
        
        valid(x, y);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        
        valid(x, y);
        
        this.charPosition = formatIntToString(x, y);
    }
    
    private void valid(int x, int y) {
        if (x < 0 || x >= COLUMN_SIZE) {
            throw new InvalidPositionException(String.format("X : %d, Y : %d 는 유효한 위치가 아닙니다.", x, y));
        }
        
        if (y < 0 || y >= ROW_SIZE) {
            throw new InvalidPositionException(String.format("X : %d, Y : %d 는 유효한 위치가 아닙니다.", x, y));
        }
    }
    
    private static String formatIntToString(int x, int y) {
        return X_ALPHABET.charAt(x) + "" + (y + 1);
    }
    
    private static int getX(String position) {
        return position.charAt(0) - 'a';
    }
    
    private static int getY(String position) {
        return Character.getNumericValue(position.charAt(1)) - 1;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String getCharPosition() {
        return charPosition;
    }
    
    public Position movePosition(Direction direction) {
        return new Position(x + direction.getXDegree(), y + direction.getYDegree());
    }
    
    public List<Position> getColumnNeighbors() {
        List<Position> columnNeighbors = new ArrayList<>();
        Optional<Position> position = createPosition(getX(), getY() - 1);
        if (position.isPresent()) {
            columnNeighbors.add(position.get());
        }
        
        position = createPosition(getX(), getY() + 1);
        if (position.isPresent()) {
            columnNeighbors.add(position.get());
        }
        return columnNeighbors;
    }
    
    private Optional<Position> createPosition(int x, int y) {
        try {
            return Optional.of(new Position(x, y));
        } catch (InvalidPositionException e) {
            return Optional.empty();
        }
    }
    
    public Direction direction(Position target) {
        return Direction.valueOf(target.x - this.x, target.y - this.y);
    }
    
    public Degree degree(Position target) {
        return new Degree(target.x - this.x, target.y - this.y);
    }
    
    public static class Degree {
        private int xDegree;
        private int yDegree;

        private Degree(int xDegree, int yDegree) {
            this.xDegree = xDegree;
            this.yDegree = yDegree;
        }

        public boolean isOverOneXDegree() {
            return xDegree > 1;
        }
        
        public boolean isOverOneYDegree() {
            return yDegree > 1;
        }
        
        public boolean isUnderThreeYDegree() {
            return yDegree > -3 && yDegree < 3;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }
}
