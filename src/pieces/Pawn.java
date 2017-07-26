package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    
    String color;
    
    Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color) {
        this.color = color;
    }

    String getColor() {
        return color;
    }
}
