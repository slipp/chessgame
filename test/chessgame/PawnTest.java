package chessgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PawnTest {
    @Test
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }
}
