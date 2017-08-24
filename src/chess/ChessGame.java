package chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");
        
        Board board = new Board();
        while(true) {
            String command = scanner.nextLine();
            if (command.equals("start")) {
                board.initialize();
                System.out.println(board.showBoard());
            } else if (command.startsWith("move")) {
                String[] values = command.split(" ");
                board.move(values[1], values[2]);
                System.out.println(board.showBoard());
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println(command + "는 지원하지 않는 명령어입니다.");
            }
        }
        
        scanner.close();
    }
}
