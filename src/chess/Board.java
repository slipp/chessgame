package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;

import pieces.Piece;

class Board {
    private static int pieceCount = 0;
    
    ArrayList<ArrayList<Piece>> pieces = new ArrayList<>();
    
    int pieceCount() {
        return pieceCount;
    }
    
    private ArrayList<Piece> initializeWhitePieces() {
        ArrayList<Piece> whitePieces = new ArrayList<Piece>();
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());
        pieceCount += 8;
        return whitePieces;
    }
    
    private ArrayList<Piece> initializeBlackPieces() {
        ArrayList<Piece> blackPieces = new ArrayList<Piece>();
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
        pieceCount += 8;
        return blackPieces;
    }
    
    private ArrayList<Piece> initializeWhitePawns() {
        ArrayList<Piece> whitePawns = new ArrayList<Piece>();
        for(int i = 0; i < 8; i++) {
            whitePawns.add(Piece.createWhitePawn());
            pieceCount++;
        }
        return whitePawns;
    }
    
    private ArrayList<Piece> initializeBlackPawns() {
        ArrayList<Piece> blackPawns = new ArrayList<Piece>();
        for(int i = 0; i < 8; i++) {
            blackPawns.add(Piece.createBlackPawn());
            pieceCount++;
        }
        return blackPawns;
    }
    
    private ArrayList<Piece> initializeBlankLine() {
        ArrayList<Piece> blankLines = new ArrayList<Piece>();
        for(int i = 0; i < 8; i++) {
            blankLines.add(Piece.createBlank());
        }
        return blankLines;
    }

    void initialize() {
       pieces.add(initializeBlackPieces());
       pieces.add(initializeBlackPawns());
       pieces.add(initializeBlankLine());
       pieces.add(initializeBlankLine());
       pieces.add(initializeBlankLine());
       pieces.add(initializeBlankLine());
       pieces.add(initializeWhitePawns());
       pieces.add(initializeWhitePieces());
    }
    
    private String showRank(ArrayList<Piece> rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }

    String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Piece> rank : pieces) {
            sb.append(showRank(rank));
        }
        return sb.toString();
    }
}
