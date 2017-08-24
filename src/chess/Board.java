package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

class Board {
    private ArrayList<Rank> ranks = new ArrayList<>();
    
    public void initialize() {
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
    
    private String showRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }

    String showBoard() {
        StringBuilder sb = new StringBuilder();
        ListIterator<Rank> rankIter = ranks.listIterator(ranks.size());
        while (rankIter.hasPrevious()) {
            sb.append(showRank(rankIter.previous()));
        }
        return sb.toString();
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Rank rank : ranks) {
            countPiece += rank.countPieceByColorAndType(color, type);
        }
        return countPiece;
    }

    public Piece findPiece(String position) {
        return findPiece(new Position(position));
    }
    
    private Piece findPiece(Position p) {
        return ranks.get(p.getYIndex()).findPiece(p.getXIndex());
    }

    public void addPiece(String target, Piece piece) {
        addPiece(new Position(target), piece);
    }
    
    public void addPiece(Position target, Piece piece) {
        piece.move(target);
        ranks.get(target.getYIndex()).move(target.getXIndex(), piece);
    }
    
    public void move(String source, String target) {
        move(new Position(source), new Position(target));
    }

    private void move(Position source, Position target) {
        Piece piece = findPiece(source);
        addPiece(source, Piece.createBlank(source));
        addPiece(target, piece);
    }

    public double caculcatePoint(Color color) {
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
}
