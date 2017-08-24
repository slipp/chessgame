package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class BishopTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Bishop.createWhite(position), Bishop.createBlack(position), Type.BISHOP);
    }
}
