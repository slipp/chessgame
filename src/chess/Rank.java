package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

class Rank {
    private ArrayList<Piece> pieces = new ArrayList<>(8);
    
    void addPiece(Piece piece) {
        pieces.add(piece);
    }
    
    Collection<Piece> getPieces() {
        return Collections.unmodifiableCollection(pieces);
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
}
