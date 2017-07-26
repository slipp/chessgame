package chess;
import java.util.ArrayList;

import pieces.Pawn;

class Board {
    ArrayList<Pawn> pawns = new ArrayList<Pawn>();
    
    void add(Pawn pawn) {
        pawns.add(pawn);
    }
    
    ArrayList<Pawn> getPawns() {
        return pawns;
    }
}
