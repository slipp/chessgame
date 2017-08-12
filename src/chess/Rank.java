package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

class Rank {
    private List<Piece> pieces = new ArrayList<>(8);
    
    void addPiece(Piece piece) {
        pieces.add(piece);
    }
    
    List<Piece> getPieces() {
        return Collections.unmodifiableList(pieces);
    }

    int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Piece piece : pieces) {
            if (piece.matchColorAndType(color, type)) {
                countPiece++;
            }
        }
        return countPiece;
    }

    static Rank initializeWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());
        return rank;
    }
    
    static Rank initializeBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());
        return rank;
    }
    
    static Rank initializeWhitePawns() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
        return rank;
    }
    
    static Rank initializeBlackPawns() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }
        return rank;
    }
    
    static Rank initializeBlankLine() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlank());
        }
        return rank;
    }

    Piece findPiece(int xPosition) {
        return pieces.get(xPosition);
    }

    public void move(int xPos, Piece piece) {
        pieces.set(xPos, piece);
    }

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> piecesByColor = new ArrayList<>();
        for (Piece piece : pieces) {
            piece.addPiecesByColor(color, piecesByColor);
        }
        return Collections.unmodifiableList(piecesByColor);
    }
}
