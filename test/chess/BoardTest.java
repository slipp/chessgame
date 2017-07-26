package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import pieces.Pawn;

public class BoardTest {
    private Board board;
    
    @Before
    public void setup() {
        board = new Board();
    }
    
    @Test
    public void create() throws Exception {
        ArrayList<Pawn> pawns = board.getPawns();
        
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.add(white);
        assertEquals(1, pawns.size());
        assertEquals(white, pawns.get(0));
        
        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.add(black); 
        assertEquals(2, pawns.size());
        assertEquals(black, pawns.get(1));
    }
    
    @Test
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
    
    @Test
    public void print() throws Exception {
        board.initialize();
        board.print();
    }
}
