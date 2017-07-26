package chess;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Pawn;

public class BoardTest {
    @Test
    public void create() throws Exception {
        Board board = new Board();
        ArrayList<Pawn> pawns = board.getPawns();
        
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, pawns.size());
        assertEquals(white, pawns.get(0));
        
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black); 
        assertEquals(2, pawns.size());
        assertEquals(black, pawns.get(1));
    }
}
