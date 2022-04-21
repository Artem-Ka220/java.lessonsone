package ru.gb.sokolov.lessonsThree;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

       /*taskOne*/

        int[] arrays = new int[]{1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(arrays));

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0) {
                arrays[i] = 1;
            } else {
                arrays[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arrays));
        /*taskTwo*/
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        /*taskThree*/
        int[] newArrays = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < newArrays.length; i++) {
            if (newArrays[i] < 6)
                newArrays[i] = newArrays[i] * 2;
        }
        System.out.println(Arrays.toString(newArrays));

        /*taskFour*/

        int[][] square = new int[4][4];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if ((i == j) || (i == square.length - 1 - j)) {
                    square[i][j] = 1;
                }
                System.out.print(" " + square[i][j] + " ");
            }
            System.out.println();
        }

        /*taskFive*/

        System.out.println(Arrays.toString(arr(6,9)));
        int[] sd = new  int[]{1,1,1,3};
        System.out.println(checkBalance(sd));

        /*taskSix*/

        int[] x = new  int[]{1,8,4,9,3,4,7,6,2,8,1,0,-4};
        int min = 0;
        int max = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < min){
                min = x[i];
            }
            if (x[i]>max){
                max = x[i];
            }
        }
        System.out.println("Минимальное число в массиве: "+min+", а максимальное: "+max+".");
    }
        /*taskSeven*/
    public static boolean checkBalance(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        if (sum % 2 != 0) {
            return false;
        }else
            sum /= 2;
            int left = 0;

        for (int i:arr)
              {
            left += i;
            if (left == sum)return true;
            if (left > sum)return  false;
        }
        return false;
    }
    public static int[] arr(int len, int initValue){
        int[]arrays = new int[len];
        Arrays.fill(arrays, initValue);
        return arrays;
    }
}
