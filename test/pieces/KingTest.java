package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class KingTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(King.createWhite(position), King.createBlack(position), Type.KING);
    }
}
