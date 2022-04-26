package ru.gb.sokolov;

import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final char DOT_HUMAN ='X';
    private static final char DOT_AI ='O';
    private static final char DOT_EMPTY ='*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char [][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static void initialize(){
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char [fieldSizeY][fieldSizeX];

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if(i % 2 == 0){
                System.out.print("-");
            }else{
                int e = i/2 + 1;
                System.out.print(e);
            }
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i <= fieldSizeX*2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты хода Х и У через пробел");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x,y) || !isCellEmpty(x,y));
        field[x][y] = DOT_HUMAN;
    }

    private static boolean checkWin(char c){
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][1] == c) return true;

        return false;
    }

    private static boolean gameCheck(char dot, String s){
        if (checkWin(dot)){
            System.out.println(s);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }


    private static boolean checkDraw(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i,j))
                    return false;
            }
        } return true;
    }

    private static boolean isCellValid(int x, int y){
       return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    private static void aiTurn(){
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x,y));
        field[y][x] = DOT_AI;
    }

    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN,"Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI,"Победил ПК!"))
                    break;
            }
            System.out.print("Будете играть ещё? (y - да): ");
            if (scanner.next().equalsIgnoreCase("y"))
                break;
        }
    }
}
