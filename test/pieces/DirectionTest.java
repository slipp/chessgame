package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {
    @Test
    public void valueOf() {
        assertEquals(Direction.NORTHEAST, Direction.valueOf(1, 1));
        assertEquals(Direction.NORTH, Direction.valueOf(0, 1));
        assertEquals(Direction.SSE, Direction.valueOf(1, -2));
    }
    
    @Test(expected = InvalidMovePositionException.class)
    public void valueOf_invalid() throws Exception {
        Direction.valueOf(2, 3);
    }
    
    @Test
    public void valueOfDiagonal() throws Exception {
        assertEquals(Direction.NORTHEAST, Direction.valueOfDiagonal(1, 1));
        assertEquals(Direction.NORTHEAST, Direction.valueOfDiagonal(4, 4));

        assertEquals(Direction.SOUTHWEST, Direction.valueOfDiagonal(-1, -1));
        assertEquals(Direction.SOUTHWEST, Direction.valueOfDiagonal(-4, -4));
        
        assertEquals(Direction.SOUTHEAST, Direction.valueOfDiagonal(1, -1));
        assertEquals(Direction.SOUTHEAST, Direction.valueOfDiagonal(4, -4));
        
        assertEquals(Direction.NORTHWEST, Direction.valueOfDiagonal(-1, 1));
        assertEquals(Direction.NORTHWEST, Direction.valueOfDiagonal(-4, 4));
    }
    
    @Test
    public void valueOfLinear() throws Exception {
        assertEquals(Direction.NORTH, Direction.valueOfLinear(0, 1));
        assertEquals(Direction.NORTH, Direction.valueOfLinear(0, 5));
        
        assertEquals(Direction.SOUTH, Direction.valueOfLinear(0, -1));
        assertEquals(Direction.SOUTH, Direction.valueOfLinear(0, -4));
        
        assertEquals(Direction.EAST, Direction.valueOfLinear(1, 0));
        assertEquals(Direction.EAST, Direction.valueOfLinear(5, 0));
        
        assertEquals(Direction.WEST, Direction.valueOfLinear(-1, 0));
        assertEquals(Direction.WEST, Direction.valueOfLinear(-5, 0));
    }
    
    @Test
    public void valueOfEvery() throws Exception {
        assertEquals(Direction.NORTHEAST, Direction.valueOfEvery(4, 4));
        assertEquals(Direction.SOUTHWEST, Direction.valueOfEvery(-4, -4));
        
        assertEquals(Direction.SOUTH, Direction.valueOfEvery(0, -4));
        assertEquals(Direction.EAST, Direction.valueOfEvery(5, 0));
    }
}
