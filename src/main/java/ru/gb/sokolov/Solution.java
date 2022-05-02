package ru.gb.sokolov;

import java.util.Arrays;

public class Solution {
        /*taskOne*/
    public static void main(String[] args) {
        Employer employer = new Employer("Великородняя Елена Александровна", "Маркетолог", "jb@gmail.com", 777777, 200000, 24);
        employer.info();

        System.out.println();
        /*taskTwo*/

        Employer[] employers = new Employer[5];
        employers[0] = new Employer("Фирс Анна Николаевна", "руководитель", "fs@gmail.com", 451214, 75000, 43);
        employers[1] = new Employer("Бездник Евгения Леонидовна", "бухгалтер", "bs@gmail.com", 456325, 80000, 35);
        employers[2] = new Employer("Земляк Маргарита Вячеславовна", "аналитик", "fg@gmail", 892356, 65000, 42);
        employers[3] = new Employer("Литвинова Ольга Витальевна", "кассир", "rt@gmail.com", 145625, 25000, 20);
        employers[4] = new Employer("Маслова Александра Николаевна", "инженер", "ms@gmail.com", 771245, 75000, 30);

        for (Employer s : employers) {
            if (s.getAge() > 40)
                System.out.println(s.getName());
        }
    }
}
