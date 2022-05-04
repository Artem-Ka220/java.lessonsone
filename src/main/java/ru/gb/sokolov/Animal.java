package ru.gb.sokolov;

public class Animal {
    private String name;
    public static int count;
    {
        count++;
    }
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){};

    public void swim(){};
}
