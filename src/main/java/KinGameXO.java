import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KinGameXO {
    static ArrayList<Integer> playersPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    static char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}, };
    public static void main(String[] args) throws IOException {

        printGameBoard(gameBoard);
       BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int playerPos; int cpuPos;

       while (true) {
           System.out.println("Enter your placement (1-9):");
           playerPos  = Integer.parseInt(bfr.readLine());

           while (playersPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
               System.out.println("Sorry, position taken");
               playerPos = Integer.parseInt(bfr.readLine());
           }

           placePiece(gameBoard, playerPos, "player");
           String result = checkWinner(gameBoard);
           if (result.length() > 0) {
               System.out.println(result);
               break;
           }
           // --------- artificial intelligence ;)------------
           Random random = new Random();
           cpuPos = random.nextInt(9) + 1;
           while (playersPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
               cpuPos = random.nextInt(9) + 1;
           }
           placePiece(gameBoard, cpuPos, "cpu");
           printGameBoard(gameBoard);
           result = checkWinner(gameBoard);
           if (result.length() > 0) {
               System.out.println(result);
               break;
           }
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
        if (user.equals("player")) {symbol = 'X'; playersPositions.add(pos);}
        if (user.equals("cpu")) {symbol = 'O'; cpuPositions.add(pos);}
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

    public static String checkWinner(char[][] gameBoard) {
        List topRaw = Arrays.asList(1, 2, 3);
        List midRaw = Arrays.asList(4, 5, 6);
        List botRaw = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List <List> winning = new ArrayList<List>();
        winning.add(topRaw);
        winning.add(midRaw);
        winning.add(botRaw);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playersPositions.containsAll(l)) {
                printGameBoard(gameBoard);
                return "Congratulations YOU WON!";
                }
            else
                if (cpuPositions.containsAll(l)) {
                    printGameBoard(gameBoard);
                    return "CPU wins! Sorry :)";
                }
                else
                    if (playersPositions.size() + cpuPositions.size() == 9) {
                        printGameBoard(gameBoard);
                        return "Ooops!";
                    }
        }
        return "";
    }
}
