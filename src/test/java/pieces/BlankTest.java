package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Piece.Type;

public class BlankTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        Blank blank = Blank.create(position);
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }
    
    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition() throws Exception {
        Blank blank = Blank.create(new Position("b3"));
        blank.verifyMovePosition(Blank.create(new Position("b4")));
    }
}
