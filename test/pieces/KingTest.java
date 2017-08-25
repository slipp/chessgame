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
        Pawn pawn = Pawn.createWhite(new Position("d3"));
        king.verifyMovePosition(pawn);
    }
    
    @Test(expected = InvalidMovePositionException.class)
    public void verifyMovePosition_sameTeam() throws Exception {
        King king = King.createWhite(new Position("d1"));
        Pawn pawn = Pawn.createWhite(new Position("d2"));
        king.verifyMovePosition(pawn);
    }
    
    @Test
    public void verifyMovePosition_otherTeam() throws Exception {
        King king = King.createWhite(new Position("d1"));
        Pawn pawn = Pawn.createBlack(new Position("e2"));
        king.verifyMovePosition(pawn);
    }
    
    @Test
    public void verifyMovePosition() throws Exception {
        King king = King.createWhite(new Position("f5"));
        king.verifyMovePosition(Blank.create(new Position("f6")));
        king.verifyMovePosition(Blank.create(new Position("e5")));
    }
}
