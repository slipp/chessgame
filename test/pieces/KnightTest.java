package pieces;

import org.junit.Test;

import pieces.Piece.Type;

public class KnightTest extends PieceTest {

    @Test
    public void create() {
        Position position = new Position(1, 1);
        verifyPiece(Knight.createWhite(position), Knight.createBlack(position), Type.KNIGHT);
    }
}
