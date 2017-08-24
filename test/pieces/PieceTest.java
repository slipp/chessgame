package pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import pieces.Piece.Type;

public class PieceTest {
    protected void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }
}
