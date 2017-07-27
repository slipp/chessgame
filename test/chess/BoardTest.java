package chess;

import static org.junit.Assert.*;

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
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.addWhitePawn(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findWhitePawn(0));
        
        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.addBlackPawn(black); 
        assertEquals(2, board.size());
        assertEquals(black, board.findBlackPawn(0));
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
