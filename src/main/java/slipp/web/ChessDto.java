package slipp.web;

import chess.Board;
import chess.ChessGame;

public class ChessDto {
    private Board board;

    private double pointByWhite;

    private double pointByBlack;
    
    private ChessDto() {}

    public Board getBoard() {
        return board;
    }

    public double getPointByWhite() {
        return pointByWhite;
    }

    public double getPointByBlack() {
        return pointByBlack;
    }

    public static ChessDto from(ChessGame chessGame) {
        ChessDto chessDto = new ChessDto();
        chessDto.board = chessGame.getBoard();
        chessDto.pointByWhite = chessGame.getPointByWhite();
        chessDto.pointByBlack = chessGame.getPointByBlack();
        
        return chessDto;
    }
}
