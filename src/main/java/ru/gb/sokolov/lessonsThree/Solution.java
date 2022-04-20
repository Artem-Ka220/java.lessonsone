package ru.gb.sokolov.lessonsThree;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] arrays = new int[]{1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(arrays));

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0){
                arrays[i] = 1;
            }else {
                arrays[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arrays));
    }
}
