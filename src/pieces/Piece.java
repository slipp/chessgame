package pieces;

/**
 * @author javajigi
 *
 */
public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');
        
        private char representation;
        
        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }
        
        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }       
    }    
    
    private Color color;
    
    private Type type;
    
    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }
    
    public Type getType() {
        return type;
    }
    
    public char getRepresentation() {
        return isWhite() ? this.type.getWhiteRepresentation() : this.type.getBlackRepresentation();
    }
    
    public boolean isWhite() {
        return matchColor(Color.WHITE);
    }
    
    public boolean isBlack() {
        return matchColor(Color.BLACK);
    }
    
    public boolean matchColorAndType(Color color, Type type) {
        return matchColor(color) && matchType(type);
    }
    
    private boolean matchColor(Color color) {
        return this.color == color;
    }

    private boolean matchType(Type type) {
        return this.type == type;
    }
    
    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }
    
    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }
    
    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }
    
    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }
    
    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }
    
    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }
    
    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Piece other = (Piece) obj;
        if (color != other.color)
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Piece [color=" + color + ", type=" + type + "]";
    }
}
