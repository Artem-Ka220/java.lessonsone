package ru.gb.sokolov.homework2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sum(15,4));
        num(45);
        System.out.println();
        System.out.println(number(20));
        write("Хороший день.", 6);
        System.out.println(year(2400));
    }
    public static boolean sum(int a, int b){
        int c = a + b;
        return c >= 10 && c <= 20;
    }
    public static void num(int num){
        if (num >=0){
            System.out.printf("Число %d положительное.", num);
        }else
            System.out.printf("Число %d отрицательное.", num);
    }
    public static boolean number(int number){
        return number >= 0 ? false : true;
    }
    public static void write(String str, int amount){
        for (int i = 0; i < amount; i++) {
            System.out.println(str);
        }
    }
    public static boolean year(int year){
        if(year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    return true;
                }else
                    return false;
            }else
                return true;
        }else
            return false;
    }
}
