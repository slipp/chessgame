package pieces;

import java.util.Arrays;
import java.util.List;

public class Position {
    private int x;
    private int y;
    
    public Position(String position) {
        this.x = position.charAt(0) - 'a';
        this.y = Character.getNumericValue(position.charAt(1)) - 1;
    }
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Position movePosition(Direction direction) {
        return new Position(x + direction.getXDegree(), y + direction.getYDegree());
    }
    
    public List<Position> getColumnNeighbors() {
        return Arrays.asList(
                new Position(getX(), getY() - 1), 
                new Position(getX(), getY() + 1));
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
