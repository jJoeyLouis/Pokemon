package com.example.pokedex.models;

public class Pokemon {
    private int id;
    private String name ;
    private int weight ;
    private int height ;
    public Pokemon(int id, String name, int weight, int height){
        this.id = id ;
        this.name = name ;
        this.weight = weight ;
        this.height = height ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
