package ru.netology;

public class Player {
    protected int id;
    protected String name;
    protected int strength;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name.toString();
        this.strength = strength;
    }
}
