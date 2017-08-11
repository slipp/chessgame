package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;

import pieces.Pawn;

class Board {
    ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
    ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();
    
    void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }
    
    void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }
    
    Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }
    
    Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }
    
    int size() {
        return whitePawns.size() + blackPawns.size();
    }

    void initialize() {
       for(int i = 0; i < 8; i++) {
           addWhitePawn(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
       }
       
       for(int i = 0; i < 8; i++) {
           addBlackPawn(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
       }
    }

    String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }
    
    String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }
    
    private String getPawnsResult(ArrayList<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
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
