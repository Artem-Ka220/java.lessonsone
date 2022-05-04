package ru.gb.sokolov;

public class CanAnimals {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурка");
        Dog dog = new Dog("Milo");

        cat.run(4);
        cat.swim();
        dog.run(4);
        dog.swim(4);

        System.out.println("Всего животных: "+Animal.count+".");
    }
}
