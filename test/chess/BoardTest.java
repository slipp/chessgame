package chess;

import static org.junit.Assert.*;
import static utils.StringUtils.appendNewLine;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class BoardTest {
    private Board board;
    
    @Before
    public void setup() {
        board = new Board();
    }
    
    @Test
    public void create() throws Exception {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(
            appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr"),
            board.showBoard());
    }
    
    @Test
    public void print() throws Exception {
        board.initialize();
        System.out.println(board.showBoard());
    }
    
    @Test
    public void countPieceByColorAndType() throws Exception {
        board.initialize();
        
        assertEquals(8, board.countPieceByColorAndType(Color.WHITE, Type.PAWN));
        assertEquals(2, board.countPieceByColorAndType(Color.BLACK, Type.KNIGHT));
        assertEquals(1, board.countPieceByColorAndType(Color.BLACK, Type.KING));
    }
    
    @Test
    public void findPiece() throws Exception {
        board.initialize();
        
        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }
    
    @Test
    public void move() throws Exception {
        board.initializeEmpty();
        
        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);
        
        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }
    
    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();
        
        board.move("b6", Piece.createBlackPawn());
        board.move("e6", Piece.createBlackQueen());
        board.move("b8", Piece.createBlackKing());
        board.move("c8", Piece.createBlackRook());
        
        
        board.move("f2", Piece.createWhitePawn());
        board.move("g2", Piece.createWhitePawn());
        board.move("e1", Piece.createWhiteRook());
        board.move("f1", Piece.createWhiteKing());
         
        assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(Color.WHITE), 0.01);
        
        System.out.println(board.showBoard());
    }
}
