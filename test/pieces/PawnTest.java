package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Piece.Type;

public class PawnTest extends PieceTest {
    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Pawn.createWhite(position), Pawn.createBlack(position), Type.PAWN);
    }
    
    @Test
    public void isStartingPosition() throws Exception {
        Pawn pawn = Pawn.createWhite(new Position("e2"));
        assertTrue(pawn.isStartingPosition());
        pawn = Pawn.createWhite(new Position("e3"));
        assertFalse(pawn.isStartingPosition());
        
        pawn = Pawn.createBlack(new Position("e7"));
        assertTrue(pawn.isStartingPosition());
        pawn = Pawn.createBlack(new Position("e6"));
        assertFalse(pawn.isStartingPosition());
    }

    @Test
    public void verifyMovePosition_starting() throws Exception {
        Pawn pawn = Pawn.createWhite(new Position("e2"));
        pawn.verifyMovePosition(new Position("e3"));
        pawn.verifyMovePosition(new Position("e4"));
        pawn.verifyMovePosition(new Position("d3"));
        pawn.verifyMovePosition(new Position("f3"));

        pawn = Pawn.createBlack(new Position("e7"));
        pawn.verifyMovePosition(new Position("e6"));
        pawn.verifyMovePosition(new Position("e5"));
        pawn.verifyMovePosition(new Position("d6"));
        pawn.verifyMovePosition(new Position("f6"));
    }

    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition_non_starting() throws Exception {
        Pawn pawn = Pawn.createWhite(new Position("e3"));
        pawn.verifyMovePosition(new Position("e5"));
    }
    
    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition_starting_overmove() throws Exception {
        Pawn pawn = Pawn.createWhite(new Position("e2"));
        pawn.verifyMovePosition(new Position("e5"));
    }

    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition_invalid_white() throws Exception {
        Pawn pawn = Pawn.createWhite(new Position("e5"));
        pawn.verifyMovePosition(new Position("e4"));
    }

    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition_invalid_black() throws Exception {
        Pawn pawn = Pawn.createBlack(new Position("e3"));
        pawn.verifyMovePosition(new Position("e4"));
    }
}
