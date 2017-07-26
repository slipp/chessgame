package chess;

import java.util.ArrayList;

import pieces.Pawn;

class Board {
    ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
    ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();
    
    void add(Pawn pawn) {
        whitePawns.add(pawn);
    }
    
    ArrayList<Pawn> getPawns() {
        return whitePawns;
    }

    void initialize() {
       for(int i = 0; i < 8; i++) {
           whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
       }
       
       for(int i = 0; i < 8; i++) {
           blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
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
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlackPawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getWhitePawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        System.out.println(sb.toString());
    }
}
