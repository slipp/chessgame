package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.ListIterator;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

class Board {
    private ArrayList<Rank> ranks = new ArrayList<>();
    
    void initialize() {
        ranks.add(Rank.initializeWhitePieces());
        ranks.add(Rank.initializeWhitePawns());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlankLine());
        ranks.add(Rank.initializeBlackPawns());
        ranks.add(Rank.initializeBlackPieces());
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
        char x = position.charAt(0);
        int xPos = x - 'a';
        char y = position.charAt(1);
        int yPos = Character.getNumericValue(y);
        return ranks.get(yPos - 1).findPiece(xPos);
    }
}
