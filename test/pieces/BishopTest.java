package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class BishopTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Bishop.createWhite(position), Bishop.createBlack(position), Type.BISHOP);
    }
    
    @Test (expected = InvalidMovePositionException.class)
    public void verifyMovePosition_invalid() throws Exception {
        Bishop bishop= Bishop.createWhite(new Position("d5"));
        bishop.verifyMovePosition(new Position("f5"));
    }
    
    @Test
    public void verifyMovePosition() throws Exception {
        Bishop bishop= Bishop.createWhite(new Position("d5"));
        bishop.verifyMovePosition(new Position("g8"));
        bishop.verifyMovePosition(new Position("a2"));
        bishop.verifyMovePosition(new Position("h1"));
        bishop.verifyMovePosition(new Position("a8"));
    }
}
