package pieces;

import java.util.Arrays;
import java.util.List;

public class Position {
    private int x;
    private int y;
    
    public Position(String position) {
        this.x = position.charAt(0) - 'a' + 1;
        this.y = Character.getNumericValue(position.charAt(1));
    }
    
    public Position(int xIndex, int yIndex) {
        this.x = xIndex + 1;
        this.y = yIndex + 1;
    }

    int getX() {
        return x;
    }
    
    int getY() {
        return y;
    }

    public int getXIndex() {
        return x -1 ;
    }
    
    public int getYIndex() {
        return y -1 ;
    }
    
    public List<Position> getColumnNeighbors() {
        return Arrays.asList(
                new Position(getXIndex(), getYIndex() - 1), 
                new Position(getXIndex(), getYIndex() + 1));
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
