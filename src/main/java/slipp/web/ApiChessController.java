package slipp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import chess.ChessGame;

@RestController
public class ApiChessController {
    @GetMapping("/api/move")
    public Result move(String source, String target) {
        ChessGame chessGame = ChessController.chessGame;
        chessGame.move(source, target);
        return Result.ok(source, target);
    }
}
