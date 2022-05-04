package ru.gb.sokolov;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public void run(int meter) {
        int[] step = new int[500];
        for (int i = 1; i < step.length; i++) {
            step[i] = i;
        }
        if (meter <= 500) {
            System.out.println("Собака " + getName() + " пробежала - "  + meter + " " + steps(step[meter]) + ".");
        } if (meter > 500){
            System.out.println("Песик такие дистанции не берёт.");
        }
    }

    public void swim(int meter) {
        if (meter <= 20) {
            System.out.println("Собака " + getName() + " проплыла - " + meter + " метров.");
        }if (meter > 20){
            System.out.println("Песик не плавает на такие расстояния.");
        }
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
