package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {
    @Test
    public void north_south() throws Exception {
        assertEquals(Direction.NORTH, Direction.valueOf(0, 1));
        assertEquals(Direction.NORTH, Direction.valueOf(0, 5));
        
        assertEquals(Direction.SOUTH, Direction.valueOf(0, -1));
        assertEquals(Direction.SOUTH, Direction.valueOf(0, -4));
    }
    
    @Test
    public void east_west() throws Exception {
        assertEquals(Direction.EAST, Direction.valueOf(1, 0));
        assertEquals(Direction.EAST, Direction.valueOf(5, 0));
        
        assertEquals(Direction.WEST, Direction.valueOf(-1, 0));
        assertEquals(Direction.WEST, Direction.valueOf(-5, 0));
    }
    
    @Test
    public void northeast_southwest() throws Exception {
        assertEquals(Direction.NORTHEAST, Direction.valueOf(1, 1));
        assertEquals(Direction.NORTHEAST, Direction.valueOf(4, 4));
        
        assertEquals(Direction.SOUTHWEST, Direction.valueOf(-1, -1));
        assertEquals(Direction.SOUTHWEST, Direction.valueOf(-4, -4));
    }
    
    @Test
    public void northwest_southeast() throws Exception {
        assertEquals(Direction.SOUTHEAST, Direction.valueOf(1, -1));
        assertEquals(Direction.SOUTHEAST, Direction.valueOf(4, -4));
        
        assertEquals(Direction.NORTHWEST, Direction.valueOf(-1, 1));
        assertEquals(Direction.NORTHWEST, Direction.valueOf(-4, 4));
    }
    

    @Test
    public void valueOf() {
        assertEquals(Direction.NORTHEAST, Direction.valueOf(1, 1));
        assertEquals(Direction.NORTH, Direction.valueOf(0, 1));
        assertEquals(Direction.SSE, Direction.valueOf(1, -2));
    }
    
    @Test(expected = InvalidMovePositionException.class)
    public void valueOf_invalid() throws Exception {
        Direction.valueOf(2, 2);
    }
}
