import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KinGameXO {
    public static void main(String[] args) throws IOException {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}, };

       BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter your placement (1-9):");
       int pos  = Integer.parseInt(bfr.readLine());
        printGameBoard(gameBoard);

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
        switch (pos) {
            case 1:
                gameBoard[0][0] = 'X';
                break;
            case 2:
                gameBoard[0][2] = 'X';
                break;
            case 3:
                gameBoard[0][4] = 'X';
                break;
            case 4:
                gameBoard[2][0] = 'X';
                break;
            case 5:
                gameBoard[2][2] = 'X';
                break;
            case 6:
                gameBoard[2][4] = 'X';
                break;
            case 7:
                gameBoard[4][0] = 'X';
                break;
            case 8:
                gameBoard[4][2] = 'X';
                break;
            case 9:
                gameBoard[4][4] = 'X';
                break;
            default:
                break;

        }

    }

}
