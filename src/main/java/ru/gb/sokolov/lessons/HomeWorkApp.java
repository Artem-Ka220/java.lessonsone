package ru.gb.sokolov.lessons;

public class HomeWorkApp {
    public static void main(String[] args) {
            printThreeWords();
            System.out.println(" ");
            checkSumSign();
            System.out.println(" ");
            printColor();
            System.out.println(" ");
            compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 26;
        int b = 16;

        int sum = a + b;

        if (sum >= 0){
            System.out.println("Сумма чисел а и b положительная.");
        } else
            System.out.println("Сумма чисел а и b отрицательная.");
    }

    public static void printColor(){
        int value = 110;
        if (value <= 0){
            System.out.println("Красный");
        }else if (value > 0 && value <= 100){
            System.out.println("Жёлтый");
        }else
            System.out.println("Зелёный");
    }

    public static void compareNumbers(){
        int a = 1119;
        int b = 281;
        if (a > b){
            System.out.println("a >= b");
        }else
            System.out.println("a < b");
    }
}

