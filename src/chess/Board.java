package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class Board {
    private List<Rank> ranks = new ArrayList<>();
    
    void initialize() {
        ranks.add(Rank.initializeWhitePieces(0));
        ranks.add(Rank.initializeWhitePawns(1));
        ranks.add(Rank.initializeBlankLine(2));
        ranks.add(Rank.initializeBlankLine(3));
        ranks.add(Rank.initializeBlankLine(4));
        ranks.add(Rank.initializeBlankLine(5));
        ranks.add(Rank.initializeBlackPawns(6));
        ranks.add(Rank.initializeBlackPieces(7));
    }
    
    void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            ranks.add(Rank.initializeBlankLine(i));
        }
    }
    
    int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Rank rank : ranks) {
            countPiece += rank.countPieceByColorAndType(color, type);
        }
        return countPiece;
    }

    Piece findPiece(Position p) {
        return ranks.get(p.getYIndex()).findPiece(p.getXIndex());
    }

    void replacePiece(Position target, Piece piece) {
        piece.move(target);
        ranks.get(target.getYIndex()).move(target.getXIndex(), piece);
    }
    
    void move(Position source, Position target) {
        Piece piece = findPiece(source);
        replacePiece(source, Piece.createBlank(source));
        replacePiece(target, piece);
    }

    double caculcatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getPoint(pieces);
        }
        
        return point;
    }

    private List<Piece> findPiecesByColor(Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Rank rank : ranks) {
            pieces.addAll(rank.findPiecesByColor(color));
        }
        return pieces;
    }
    
    public List<Rank> getRanks() {
        return Collections.unmodifiableList(ranks);
    }
}
