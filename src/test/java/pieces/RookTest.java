package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class RookTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Rook.createWhite(position), Rook.createBlack(position), Type.ROOK);
    }
    
    @Test (expected = InvalidMovePositionException.class)
    public void verifyMovePosition_invalid() throws Exception {
        Rook rook= Rook.createWhite(new Position("d1"));
        rook.verifyMovePosition(Pawn.createWhite(new Position("e6")));
    }
    
    @Test
    public void verifyMovePosition() throws Exception {
        Rook rook= Rook.createWhite(new Position("d5"));
        rook.verifyMovePosition(Blank.create(new Position("d8")));
        rook.verifyMovePosition(Blank.create(new Position("d1")));
        rook.verifyMovePosition(Blank.create(new Position("a5")));
        rook.verifyMovePosition(Blank.create(new Position("h5")));
    }
}
