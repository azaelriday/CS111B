// Author: Azael Riday
// Last Modification: Mar.19th
// Course: CS111B
// File Name: TicTacToeZver.java

import java.util.*;

public class TicTacToeZver{
    static Scanner scanner = new Scanner(System.in);

    public static char[][] initBoard() {
        System.out.print("Board size: ");
        int size = scanner.nextInt();
        char[][] board = new char[size][size];
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[0].length; column++){
                board[row][column] = '-';
            }
        }
        return board;
    }

    public static void display(char[][] board){
        for (int row = 0; row < board.length; row++){
            System.out.println("-----------");
            for (int column = 0; column < board[0].length; column++){
                System.out.print("  " + board[row][column]);
            }
            System.out.println();
        }
        System.out.println("-----------");
        System.out.println();
    }

    public static boolean winByRow(char currentPlayer, char[][] board){
        for(int row = 0; row < board.length; row++){
            boolean win = true;
            for(int column = 0; column < board[0].length; column++){
                if (board[row][column] != currentPlayer){
                    win = false;
                    break;
                }
            }
            if (win){
                return win;
            }
        }
        return false;
    }

    public static boolean winByColumn(char currentPlayer, char[][] board){
        for(int column = 0; column < board[0].length; column++){
            boolean win = true;
            for(int row = 0; row < board.length; row++){
                if (board[row][column] != currentPlayer){
                    win = false;
                    break;
                }
            }
            if (win){
                return win;
            }
        }
        return false;
    }

    public static boolean winByDiagonal(char currentPlayer, char[][] board){
        for(int i = 0; i < board.length; i++){
            if (board[i][i] != currentPlayer){
                return false;
            }
        }
        return true;
    }

    public static boolean winByAntiDiagonal(char currentPlayer, char[][] board){
        for(int i = 0; i < board.length; i++){
            if (board[i][board.length - 1 -i] != currentPlayer){
                return false;
            }
        }
        return true;
    }

    public static boolean isWinning(char currentPlayer, char[][] board){
        if (winByRow(currentPlayer, board) ||
            winByColumn(currentPlayer, board) ||
            winByDiagonal(currentPlayer, board) ||
            winByAntiDiagonal(currentPlayer, board)){
            return true;
        }
        return false;
    }

    public static boolean haveDash(char[][] board) {
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[0].length; column++){
                if (board[row][column] == '-'){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTie(char currentPlayer, char[][] board){
        if (haveDash(board) ||
            isWinning(currentPlayer, board)){
            return false;
        }
        return true;
    }

    public static boolean takeTurn(char currentPlayer, char[][] board){
        int row = 0;
        int column = 0;
        boolean isGameOver = false;

        System.out.println(currentPlayer + ", this is your turn. Enter row col (0 0 is top left)");
        row = scanner.nextInt();
        column = scanner.nextInt();
        while (board[row][column] != '-'){ // check validity of the coordinate player choose
            System.out.println("The block has been chosen, choose another one.");
            row = scanner.nextInt();
            column = scanner.nextInt();
        }
        /*  this can't seems to fix index out of bound problem
        while (row < 0 || row > 2 || column < 0 || column > 2){
            System.out.println("Index out of bounds, choose number between 0 and 2.");
            row = scanner.nextInt();
            column = scanner.nextInt();
        }
        */

        board[row][column] = currentPlayer;

        if (isWinning(currentPlayer, board)){ // check game status
            System.out.println("You have won! Congrats!");
            isGameOver = true;
        } else if (isTie(currentPlayer, board)){
            System.out.println("You have reach a tie situation, the game is over");
            isGameOver = true;
        }
        return isGameOver;
    }

    public static void main(String[] args) {
        char mainCurrentPlayer = 'X';
        char[][] mainBoard = initBoard();
        boolean mainGameOver = false;

        // display board
        System.out.println("Time to play some Tic Tac Toe!");
        display(mainBoard);
        while (!mainGameOver){
            mainGameOver = takeTurn(mainCurrentPlayer, mainBoard);
            display(mainBoard);

            // switch player
            if (mainCurrentPlayer == 'X'){
                mainCurrentPlayer = 'O';
            } else {
                mainCurrentPlayer = 'X';
            }
        }
    }
}
