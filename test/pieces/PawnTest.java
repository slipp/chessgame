package pieces;
import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Pawn;

public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }
    
    @Test
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }
}
