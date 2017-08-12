package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

class Board {
    private ArrayList<Rank> ranks = new ArrayList<>();
    
    public void initialize() {
        ranks.add(Rank.initializeWhitePieces());
        ranks.add(Rank.initializeWhitePawns());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlackPawns());
        ranks.add(Rank.initializeBlackPieces());
    }
    
    void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            ranks.add(Rank.initializeBlankLine());
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
        Position p = new Position(position);
        return ranks.get(p.getYIndex()).findPiece(p.getXIndex());
    }

    public void move(String position, Piece piece) {
        Position p = new Position(position);
        ranks.get(p.getYIndex()).move(p.getXIndex(), piece);
    }

    public double caculcatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getPoint();
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
