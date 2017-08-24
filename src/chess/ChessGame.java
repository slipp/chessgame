package chess;

import pieces.Position;

public class ChessGame {
    private Board board = new Board();
    
    public Board getBoard() {
        return board;
    }

    public void initialize() {
        board.initialize();
    }

    public void move(String source, String target) {
        board.move(new Position(source), new Position(target));
    }
}
