package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    
    String color;
    char representation;
    
    Pawn() {
        this(WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    String getColor() {
        return color;
    }
    
    public char getRepresentation() {
        return representation;
    }
}
