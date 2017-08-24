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
        Direction.valueOf(2, 2);
    }
}
