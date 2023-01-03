import java.util.*;
public class TicTacToe {
    private String[][] board;
    static String X = "X";
    static String O = "O";
    //Contructor
    public TicTacToe() {
        // initialize instance variables
        board = new String[3][3];
    }

    //TicTacToe Board
    public void printBoard() {  //prints the board
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    System.out.print("_");
                } else {
                    System.out.print(board[i][j]);
                }
                if (j < 2) {
                    System.out.print("|");
                } else {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
    //to check if someone wins or not
    public Boolean checkWin(String total) { //checks to see if someone wins or not
        int row = 0;
        int total1 = 0;
        int total2 = 0;
        int[] col = new int[board[0].length];   //inputs square board
        for (int i = 0; i < board.length; i++) {
            row = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (null == board[i][j]) {
                    continue;
                }
                if (board[i][j].equals(total)) {
                    row++;
                    col[j]++;
                    if (i == j) {
                        total1++;
                    } else if (2 == i + j) {
                        total2++;
                    }
                }

            }
            if (row == 3) {
                return true;
            }
        }
        if (3 == total1 || 3 == total2) {
            return true;
        }
        for (int i = 0; i < col.length; i++) {
            if (col[i] == 3) {
                return true;
            }
        }
        return false;
    }
    //gets cordinate for turn thats not occupied and replacing it with string
    public void move(Scanner scan, String total) {
        int a;
        int b;
        Boolean goodInput = false;
        while(!goodInput) {
            a = -1;
            b = -1;
            System.out.println ("Enter coordinates to total your " + total);
            if (scan.hasNextInt()) {  //can only be ints
                a = scan.nextInt();
            }
            if (scan.hasNextInt()) {
                b = scan.nextInt();
            }
            else {
                scan.nextLine();
                System.out.println("Both cordinates chosen must be numbers between 0 and 2.");
                continue;
            }
            // must be within right cordinates range
            if ((a < 0) || (a > 2) || (b < 0) || (b > 2)) {
                System.out.println("Both cordinates chosen must be numbers between 0 and 2.");
                continue;
            }
            // makes sure the chosen space is not occupied already
            else if (board[a][b] != null ){
                System.out.println("That location on the board already has a mark");
                continue;
            }
            else {
                board[a][b] = total;
                return;
            }
        }
        return;
    }

    public static void main(String[] args) {

        TicTacToe counter = new TicTacToe();
        Scanner scan = new Scanner(System.in);

        int turns = 0;
        System.out.println("TicTacToe, X's goes first");
        counter.printBoard();
        while (turns < 9) {
            counter.move(scan, counter.X);
            turns++;
            if (turns > 4) {
                if (counter.checkWin(X)) {
                   System.out.println(X + " Your the Winner!!!");
                   break;
                }
            }
            counter.printBoard();
            counter.move(scan, counter.O);
            turns++;
            if (turns > 4) {
                if (counter.checkWin(O)) {
                   System.out.println(O + " Your the Winner!!!");
                   break;
                }
            }
            counter.printBoard();

        }
    }
}
