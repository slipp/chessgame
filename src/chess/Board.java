package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;

import pieces.Piece;

class Board {
    private static int pieceCount = 0;
    
    ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    ArrayList<Piece> whitePawns = new ArrayList<Piece>();
    ArrayList<Piece> blackPieces = new ArrayList<Piece>();
    ArrayList<Piece> blackPawns = new ArrayList<Piece>();
    
    private void addWhitePawn(Piece pawn) {
        pieceCount++;
        whitePawns.add(pawn);
    }
    
    private void addWhitePiece(Piece piece) {
        pieceCount++;
        whitePieces.add(piece);
    }
    
    private void addBlackPiece(Piece piece) {
        pieceCount++;
        blackPieces.add(piece);
    }
    
    private void addBlackPawn(Piece pawn) {
        pieceCount++;
        blackPawns.add(pawn);
    }
    
    int pieceCount() {
        return pieceCount;
    }

    void initialize() {
       addWhitePiece(Piece.createWhiteRook());
       addWhitePiece(Piece.createWhiteKnight());
       addWhitePiece(Piece.createWhiteBishop());
       addWhitePiece(Piece.createWhiteQueen());
       addWhitePiece(Piece.createWhiteKing());
       addWhitePiece(Piece.createWhiteBishop());
       addWhitePiece(Piece.createWhiteKnight());
       addWhitePiece(Piece.createWhiteRook());
       for(int i = 0; i < 8; i++) {
           addWhitePawn(Piece.createWhitePawn());
       }
       
       for(int i = 0; i < 8; i++) {
           addBlackPawn(Piece.createBlackPawn());
       }
       addBlackPiece(Piece.createBlackRook());
       addBlackPiece(Piece.createBlackKnight());
       addBlackPiece(Piece.createBlackBishop());
       addBlackPiece(Piece.createBlackQueen());
       addBlackPiece(Piece.createBlackKing());
       addBlackPiece(Piece.createBlackBishop());
       addBlackPiece(Piece.createBlackKnight());
       addBlackPiece(Piece.createBlackRook());
    }

    private String getWhitePawnsResult() {
        return getPieceResult(whitePawns);
    }
    
    private String getWhitePiecesResult() {
        return getPieceResult(whitePieces);
    }
    
    private String getBlackPawnsResult() {
        return getPieceResult(blackPawns);
    }
    
    private String getBlackPiecesResult() {
        return getPieceResult(blackPieces);
    }
    
    private String getPieceResult(ArrayList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
    
    String showBoard() {
        String blankRank = appendNewLine("........"); 
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlackPiecesResult()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(blankRank);
        sb.append(blankRank);
        sb.append(blankRank);
        sb.append(blankRank);
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getWhitePiecesResult()));
        return sb.toString();
    }
}
