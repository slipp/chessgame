package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Position;

public class PositionTest {
    @Test
    public void create() {
        Position position = new Position("a1");
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
        
        assertEquals(0, position.getXIndex());
        assertEquals(0, position.getYIndex());        
    }
}
