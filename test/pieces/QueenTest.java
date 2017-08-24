package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class QueenTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Queen.createWhite(position), Queen.createBlack(position), Type.QUEEN);
    }
}
