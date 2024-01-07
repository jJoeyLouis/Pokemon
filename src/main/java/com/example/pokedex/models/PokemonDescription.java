package com.example.pokedex.models;

public class PokemonDescription extends Pokemon{
    // I create a legacy, to avoid to repeat the code.
    private String description ;
    public PokemonDescription(int id, String name, int weight, int height, String description){
        super(id,name,weight,height) ;
        this.description = description ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
