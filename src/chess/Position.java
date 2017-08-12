package chess;

class Position {
    private int x;
    private int y;
    
    Position(String position) {
        this.x = position.charAt(0) - 'a' + 1;
        this.y = Character.getNumericValue(position.charAt(1));
    }

    int getX() {
        return x;
    }
    
    int getY() {
        return y;
    }

    int getXIndex() {
        return x -1 ;
    }
    
    int getYIndex() {
        return y -1 ;
    }
}
