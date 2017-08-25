package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class KingTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(King.createWhite(position), King.createBlack(position), Type.KING);
    }
    
    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition_inValid() throws Exception {
        King king = King.createWhite(new Position("d1"));
        king.verifyMovePosition(new Position("d3"));
    }
    
    @Test
    public void verifyMovePosition() throws Exception {
        King king = King.createWhite(new Position("f5"));
        king.verifyMovePosition(new Position("f6"));
        king.verifyMovePosition(new Position("e5"));
        king.verifyMovePosition(new Position("g5"));
        king.verifyMovePosition(new Position("g6"));
        king.verifyMovePosition(new Position("e4"));
    }
}
