package slipp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import chess.ChessGame;

@Controller
public class ChessController {
    public static ChessGame chessGame;

    public ChessController() {
        chessGame = new ChessGame();
        chessGame.initialize();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("chessGame", ChessDto.from(chessGame));
        return "chessboard";
    }
    
    @PostMapping("/move")
    public String move(String source, String target, Model model) {
        chessGame.move(source, target);
        model.addAttribute("chessGame", ChessDto.from(chessGame));
        return "chessboard";
    }
}
