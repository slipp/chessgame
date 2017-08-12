package pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pieces.Piece.Type;

public class PieceTest {
    @Test
    public void create_piece() {
        Position position = new Position(1, 1);
        verifyPiece(Piece.createWhitePawn(position), Piece.createBlackPawn(position), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(position), Piece.createBlackKnight(position), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(position), Piece.createBlackRook(position), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(position), Piece.createBlackBishop(position), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(position), Piece.createBlackQueen(position), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(position), Piece.createBlackKing(position), Type.KING);
        
        Piece blank = Piece.createBlank(position);
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }
    
    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }
    
    @Test
    public void isWhiteAndBlack() throws Exception {
        Position position = new Position(1, 1);
        Piece whitePawn = Piece.createWhitePawn(position);
        assertTrue(whitePawn.isWhite());
        assertEquals('p', whitePawn.getRepresentation());
        
        Piece blackPawn = Piece.createBlackPawn(position);
        assertTrue(blackPawn.isBlack());
        assertEquals('P', blackPawn.getRepresentation());
    }
}
