package ru.gb.sokolov;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int MINES_COUNT = 20;
    public static final int MINE = 1000;
    public static final int EMPTY = 0;
    private static final int CELL_OPEN = 1;
    public static final int CELL_CLOSED = 0;
    private static final int CELL_FLAG = -1;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        boolean userWin = play();
        if (userWin){
            System.out.println("Поздравляю! Вы выиграли! ");
        }else {
            System.out.println("BOOM!!");
        }
    }

    private static boolean play() {
        boolean win = true;
        int[][] board = generateBoard();
        int[][] moves = new int[HEIGHT][WIDTH];
        boolean isPassMove;

        do {
            isPassMove = move(board, moves);
            win = isWin(moves);
        } while (isPassMove && !win);
        return isPassMove;
    }

    private static boolean isWin(int[][] moves) {
        int openCell = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (moves[i][j] == CELL_OPEN){
                    openCell++;
                }
            }
        }
        return openCell + MINES_COUNT == HEIGHT * WIDTH;

    }

    private static boolean move(int[][] board, int[][] moves) {
        Scanner scanner = new Scanner(System.in);
        printBoard(moves, board);
        int row, line;
        while (true){
            System.out.print("Ваш ход (столбец, строка. Например А1): ");
            String move = scanner.nextLine();
            row = move.charAt(0) - 'A';
            line = move.charAt(1) - '0';
                if (row < WIDTH && row >= 0 && line < HEIGHT && line >= 0 ){
                    break;
                }
            System.out.println("Введите координаты внутри поля!");
        }
        if (board[line][row] != MINE){
            moves[line][row] = CELL_OPEN;
            return  true;
        }
        return false;
    }

    private static void printBoard(int[][] moves, int[][] board) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d",i);
            for (int j = 0; j < WIDTH; j++) {
                if (moves[i][j] == CELL_CLOSED){
                    System.out.print("[]");
                    continue;
                }
                if (moves[i][j] == CELL_FLAG){
                    System.out.print(" P");
                    continue;
                }
                String colorCode = getColorCode(board[i][j]);
                System.out.print(colorCode);
                if (board[i][j] == EMPTY){
                    System.out.print(" .");
                }else if (board[i][j]== MINE){
                    System.out.print(" *");
                }else {
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }

    }
    
    public static String getColorCode(int i){
        switch (i){
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }
    }
    

    private static int[][] generateBoard() {
        int[][] board = new int[HEIGHT][WIDTH];
        Random random = new Random();
        int mines = MINES_COUNT;
        while (mines > 0){
            int x, y;
            do {
                x = random.nextInt(HEIGHT);
                y = random.nextInt(WIDTH);
            }while (board[x][y] == MINE);
            board[x][y] = MINE;
            mines--;
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE){
                    continue;
                }
                int mCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j -1; l <= j + 1; l++) {
                        if (k < 0 || k >= HEIGHT || l < 0 || l >= WIDTH){
                            continue;
                        }
                        if (board[k][l] == MINE){
                            mCount++;
                        }
                    }
                }
                board[i][j] = mCount;
            }
        }

        return board;
    }
}
