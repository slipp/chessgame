package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;

public class BoardTest {
    private Board board;
    
    @Before
    public void setup() {
        board = new Board();
    }
    
    @Test
    public void create() throws Exception {
        Piece white = Piece.createWhitePawn();
        board.addWhitePawn(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findWhitePawn(0));
        
        Piece black = Piece.createBlackPawn();
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
