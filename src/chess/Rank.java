package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
import pieces.Position;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class Rank {
    private List<Piece> pieces = new ArrayList<>(8);
    
    void addPiece(Piece piece) {
        pieces.add(piece);
    }
    
    public List<Piece> getPieces() {
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

    static Rank initializeWhitePieces(int index) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook(new Position(0, index)));
        rank.addPiece(Piece.createWhiteKnight(new Position(1, index)));
        rank.addPiece(Piece.createWhiteBishop(new Position(2, index)));
        rank.addPiece(Piece.createWhiteQueen(new Position(3, index)));
        rank.addPiece(Piece.createWhiteKing(new Position(4, index)));
        rank.addPiece(Piece.createWhiteBishop(new Position(5, index)));
        rank.addPiece(Piece.createWhiteKnight(new Position(6, index)));
        rank.addPiece(Piece.createWhiteRook(new Position(7, index)));
        return rank;
    }
    
    static Rank initializeBlackPieces(int index) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook(new Position(0, index)));
        rank.addPiece(Piece.createBlackKnight(new Position(1, index)));
        rank.addPiece(Piece.createBlackBishop(new Position(2, index)));
        rank.addPiece(Piece.createBlackQueen(new Position(3, index)));
        rank.addPiece(Piece.createBlackKing(new Position(4, index)));
        rank.addPiece(Piece.createBlackBishop(new Position(5, index)));
        rank.addPiece(Piece.createBlackKnight(new Position(6, index)));
        rank.addPiece(Piece.createBlackRook(new Position(7, index)));
        return rank;
    }
    
    static Rank initializeWhitePawns(int index) {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createWhitePawn(new Position(i, index)));
        }
        return rank;
    }
    
    static Rank initializeBlackPawns(int index) {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlackPawn(new Position(i, index)));
        }
        return rank;
    }
    
    static Rank initializeBlankLine(int index) {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createBlank(new Position(i, index)));
        }
        return rank;
    }

    Piece findPiece(int xPosition) {
        return pieces.get(xPosition);
    }

    void move(int xPos, Piece piece) {
        pieces.set(xPos, piece);
    }

    List<Piece> findPiecesByColor(Color color) {
        List<Piece> piecesByColor = new ArrayList<>();
        for (Piece piece : pieces) {
            piece.addPiecesByColor(color, piecesByColor);
        }
        return Collections.unmodifiableList(piecesByColor);
    }
}
