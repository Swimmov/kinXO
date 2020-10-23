import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class KinGameXO {
    public static void main(String[] args) throws IOException {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}, };
        printGameBoard(gameBoard);
       BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int playerPos;
       while (true) {
           System.out.println("Enter your placement (1-9):");
           playerPos  = Integer.parseInt(bfr.readLine());

           placePiece(gameBoard, playerPos, "player");

           // --------- artifitial intelegens ;)------------
           Random random = new Random();
           int cpuPos = random.nextInt(9) + 1;
           placePiece(gameBoard, cpuPos, "cpu");
           printGameBoard(gameBoard);
       }


    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char [] raw : gameBoard) {
            for (char c : raw) {
                System.out.print(c);
            }
            System.out.println();

        }
    }
    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {symbol = 'X';}
        if (user.equals("cpu")) {symbol = 'O';}
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        }

    }

}
