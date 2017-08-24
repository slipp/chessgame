package chess;

import static org.junit.Assert.assertEquals;
import static utils.StringUtils.appendNewLine;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;
import view.ChessView;

public class BoardTest {
    private Board board;
    private ChessView chessView;

    @Before
    public void setup() {
        board = new Board();
        chessView = new ChessView();
    }

    @Test
    public void create() throws Exception {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(appendNewLine("RNBQKBNR") + 
                appendNewLine("PPPPPPPP") + 
                blankRank + 
                blankRank + 
                blankRank + 
                blankRank + 
                appendNewLine("pppppppp") + 
                appendNewLine("rnbqkbnr"), chessView.view(board));
    }

    @Test
    public void print() throws Exception {
        board.initialize();
        System.out.println(chessView.view(board));
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

        assertFindPiece(Piece.createBlackRook(new Position("a8")));
        assertFindPiece(Piece.createBlackRook(new Position("h8")));
        assertFindPiece(Piece.createWhiteRook(new Position("a1")));
        assertFindPiece(Piece.createWhiteRook(new Position("h1")));
    }
    
    private void assertFindPiece(Piece piece) {
        assertEquals(piece, board.findPiece(piece.getPosition()));
    }

    @Test
    public void addPiece() throws Exception {
        board.initializeEmpty();

        Position position = new Position("b5");
        Piece piece = Piece.createBlackRook(position);
        board.replacePiece(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(chessView.view(board));
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece(Piece.createBlackPawn(new Position("b6")));
        addPiece(Piece.createBlackQueen(new Position("e6")));
        addPiece(Piece.createBlackKing(new Position("b8")));
        addPiece(Piece.createBlackRook(new Position("c8")));

        addPiece(Piece.createWhitePawn(new Position("f2")));
        addPiece(Piece.createWhitePawn(new Position("g2")));
        addPiece(Piece.createWhiteRook(new Position("e1")));
        addPiece(Piece.createWhiteKing(new Position("f1")));

        assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(Color.WHITE), 0.01);

        System.out.println(chessView.view(board));
    }

    @Test
    public void caculcatePoint_pawn() throws Exception {
        board.initializeEmpty();

        addPiece(Piece.createBlackPawn(new Position("b6")));
        addPiece(Piece.createBlackPawn(new Position("b5")));
        addPiece(Piece.createBlackPawn(new Position("b4")));
        
        assertEquals(1.5, board.caculcatePoint(Color.BLACK), 0.01);
    }
    
    @Test
    public void move() throws Exception {
        board.initialize();
        
        Position sourcePosition = new Position("b2");
        Position targetPosition = new Position("b3");
        board.move(sourcePosition, targetPosition);
        assertEquals(Piece.createBlank(sourcePosition), board.findPiece(sourcePosition));
        assertEquals(Piece.createWhitePawn(targetPosition), board.findPiece(targetPosition));
    }
    
    private void addPiece(Piece piece) {
        board.replacePiece(piece.getPosition(), piece);
    }
}
