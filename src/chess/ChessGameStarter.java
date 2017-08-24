package chess;

import java.util.Scanner;

import view.ChessView;

public class ChessGameStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");
        
        ChessGame chessGame = new ChessGame();
        ChessView chessView = new ChessView();
        while(true) {
            String command = scanner.nextLine();
            if (command.equals("start")) {
                chessGame.initialize();
                System.out.println(chessView.view(chessGame.getBoard()));
            } else if (command.startsWith("move")) {
                String[] values = command.split(" ");
                chessGame.move(values[1], values[2]);
                System.out.println(chessView.view(chessGame.getBoard()));
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println(command + "는 지원하지 않는 명령어입니다.");
            }
        }
        
        scanner.close();
    }
}
