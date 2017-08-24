package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class RookTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Rook.createWhite(position), Rook.createBlack(position), Type.ROOK);
    }
}
