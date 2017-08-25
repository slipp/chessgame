package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class QueenTest extends PieceTest {
    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Queen.createWhite(position), Queen.createBlack(position), Type.QUEEN);
    }
    
    @Test (expected = InvalidMovePositionException.class)
    public void verifyMovePosition_invalid() throws Exception {
        Queen queen= Queen.createWhite(new Position("d4"));
        queen.verifyMovePosition(new Position("h2"));
    }
    
    @Test
    public void verifyMovePosition() throws Exception {
        Queen queen= Queen.createWhite(new Position("d4"));
        queen.verifyMovePosition(new Position("a1"));
        queen.verifyMovePosition(new Position("a4"));
        queen.verifyMovePosition(new Position("a7"));
        queen.verifyMovePosition(new Position("h4"));
        queen.verifyMovePosition(new Position("h8"));
        queen.verifyMovePosition(new Position("d1"));
        queen.verifyMovePosition(new Position("d8"));
    }
}
