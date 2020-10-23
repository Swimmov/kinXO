public class KinGameXO {
    public static void main(String[] args) {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}, };
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
}
