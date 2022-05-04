package ru.gb.sokolov;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void run(int meter) {
        int[] step = new int[200];
        for (int i = 1; i < step.length; i++) {
            step[i] = i;
        }
        if (meter <= 200) {
            System.out.println("Кот " + getName() + " пробежал - " + meter + " " + steps(step[meter]) + ".");
        }
        if (meter > 200) {
            System.out.println("Котик столько не бегает.");
        }
    }

    public void swim() {
        System.out.println("Кот " + getName() + " плавать не умеет.");
    }

    public static String steps(int count) {
        String one = "метр";
        String two = "метра";
        String three = "метров";

        if (count > 100)
            count %= 100;
        if (count > 20)
            count %= 10;
        switch (count) {
            case 1:
                return one;
            case 2:
            case 3:
            case 4:
                return two;
            default:
                return three;
        }
    }
}