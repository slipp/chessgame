package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {
    @Test
    public void create() {
        Position position = new Position("a1");
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }
    
    @Test
    public void direction() throws Exception {
        Position source = new Position("a1");
        Position target = new Position("a2");
        
        assertEquals(Direction.NORTH, source.direction(target));
    }
}
