package pieces;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PositionTest {
    @Test
    public void create() {
        Position position = new Position("a1");
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals("a1", position.getCharPosition());
    }
    
    @Test
    public void create_xy() throws Exception {
        Position position = new Position(0, 0);
        assertEquals("a1", position.getCharPosition());
    }
    
    @Test(expected = InvalidPositionException.class)
    public void create_문자_길이_2보다_작은_경우() throws Exception {
        new Position("a");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void create_체스판_ROW_크기_작은_경우() throws Exception {
        new Position("a0");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void create_체스판_ROW_크기_큰_경우() throws Exception {
        new Position("a9");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void create_체스판_COLUMN_크기_작은_경우() throws Exception {
        new Position("Z2");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void create_체스판_COLUMN_크기_큰_경우() throws Exception {
        new Position("i2");
    }
    
    @Test
    public void direction() throws Exception {
        Position source = new Position("a1");
        Position target = new Position("a2");
        
        assertEquals(Direction.NORTH, source.direction(target));
    }
    
    @Test
    public void getColumnNeighbors() throws Exception {
        Position position = new Position("a2");
        List<Position> neighboars = position.getColumnNeighbors();
        assertTrue(neighboars.contains(new Position("a1")));
        assertTrue(neighboars.contains(new Position("a3")));
        
        position = new Position("a1");
        neighboars = position.getColumnNeighbors();
        assertTrue(neighboars.contains(new Position("a2")));
    }
}
