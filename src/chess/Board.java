package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;

import pieces.Piece;

class Board {
    ArrayList<Piece> whitePawns = new ArrayList<Piece>();
    ArrayList<Piece> blackPawns = new ArrayList<Piece>();
    
    void addWhitePawn(Piece pawn) {
        whitePawns.add(pawn);
    }
    
    void addBlackPawn(Piece pawn) {
        blackPawns.add(pawn);
    }
    
    Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }
    
    Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }
    
    int size() {
        return whitePawns.size() + blackPawns.size();
    }

    void initialize() {
       for(int i = 0; i < 8; i++) {
           addWhitePawn(Piece.createWhitePawn());
       }
       
       for(int i = 0; i < 8; i++) {
           addBlackPawn(Piece.createBlackPawn());
       }
    }

    String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }
    
    String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }
    
    private String getPawnsResult(ArrayList<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Piece pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }
    
    private String getBlankLine() {
        return "........";
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        System.out.println(sb.toString());
    }
}
